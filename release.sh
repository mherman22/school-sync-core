#!/bin/bash

# This script will: 
# Update the version numbers in pom.xml and package.json
# Update the CHANGELOG.md file
# Update the Dockerfile with the new version label
# Commit the changes
# Create a new git tag
# Push the changes and tag to the repository
# Build and push a new Docker image with the version tag

# Check if a version number was provided
if [ -z "$1" ]; then
    echo "Please provide a version number (e.g., 1.0.1)"
    exit 1
fi

NEW_VERSION=$1

# Update version in pom.xml
mvn versions:set -DnewVersion=$NEW_VERSION
mvn versions:commit

# Update version in package.json
cd frontend
npm version $NEW_VERSION --no-git-tag-version
cd ..

# Update CHANGELOG.md
DATE=$(date +%Y-%m-%d)
sed -i "s/## \[Unreleased\]/## [Unreleased]\n\n## [$NEW_VERSION] - $DATE/" CHANGELOG.md

# Update Dockerfile
sed -i "s/org.opencontainers.image.version=\".*\"/org.opencontainers.image.version=\"$NEW_VERSION\"/" Dockerfile

# Commit changes
git add pom.xml frontend/package.json CHANGELOG.md Dockerfile
git commit -m "Release version $NEW_VERSION"

# Create a new tag
git tag -a v$NEW_VERSION -m "Version $NEW_VERSION"

# Push changes and tags
git push origin main
git push origin v$NEW_VERSION

# Build and push Docker image
docker build -t mbarara-girls-ss:$NEW_VERSION .
docker push mbarara-girls-ss:$NEW_VERSION

echo "Released version $NEW_VERSION"
