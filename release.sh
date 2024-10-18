#!/bin/bash

# This script will: 
# Update the version numbers in pom.xml and package.json
# Update the CHANGELOG.md file
# Update the Dockerfile with the new version label
# Commit the changes
# Create a new git tag
# Push the changes and tag to the repository
# Build and push a new Docker image with the version tag

# Check if version number is provided
if [ -z "$1" ]; then
    echo "Please provide a version number"
    exit 1
fi

# Check if commit message is provided
if [ -z "$2" ]; then
    echo "Please provide a commit message"
    exit 1
fi

RELEASE_VERSION=$1
COMMIT_MESSAGE=$2
NEXT_SNAPSHOT_VERSION=$(echo $RELEASE_VERSION | awk -F. '{$NF = $NF + 1;} 1' | sed 's/ /./g')-SNAPSHOT

# Update version in pom.xml
mvn versions:set -DnewVersion=$RELEASE_VERSION
mvn versions:commit

# Update version in package.json
cd frontend
npm version $RELEASE_VERSION --no-git-tag-version
cd ..

# Update CHANGELOG.md
echo "## [$RELEASE_VERSION] - $(date +%Y-%m-%d)" >> CHANGELOG.md
echo "" >> CHANGELOG.md
echo "<!-- Add release notes here -->" >> CHANGELOG.md
echo "" >> CHANGELOG.md
cat CHANGELOG.md >> CHANGELOG.tmp && mv CHANGELOG.tmp CHANGELOG.md

# Update Dockerfile
sed -i "s/org.opencontainers.image.version=\".*\"/org.opencontainers.image.version=\"$RELEASE_VERSION\"/" Dockerfile

# Commit release changes
git add pom.xml frontend/package.json CHANGELOG.md Dockerfile
git commit -m "$COMMIT_MESSAGE"

# Create a new tag
git tag -a v$RELEASE_VERSION -m "Version $RELEASE_VERSION"

# Push release changes and tags
git push origin main
git push origin v$RELEASE_VERSION

# Build and push Docker image
docker build -t school-sync-core:$RELEASE_VERSION .
docker push school-sync-core:$RELEASE_VERSION

echo "Released version $RELEASE_VERSION"

# Update to next snapshot version
mvn versions:set -DnewVersion=$NEXT_SNAPSHOT_VERSION
mvn versions:commit

cd frontend
npm version $NEXT_SNAPSHOT_VERSION --no-git-tag-version
cd ..

# Commit snapshot version update
git add pom.xml frontend/package.json
git commit -m "Prepare for next development iteration $NEXT_SNAPSHOT_VERSION"
git push origin main

echo "Updated to next snapshot version $NEXT_SNAPSHOT_VERSION"
