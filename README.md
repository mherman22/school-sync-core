# school-sync-core System

This project contains both the backend (Java Spring) and frontend (Next.js) for the school-sync-core system. The attempts to provide a school management system that is wholistic in nature.

## Running with Docker Compose

To run the entire application (backend, frontend, database, and Nginx) using Docker Compose:

1. Make sure you have Docker and Docker Compose installed on your system.
2. Create a fork of the repository

3. Clone this repository:
   ```
   git clone https://github.com/your-github-username/school-sync-core.git
   cd school-sync-core
   ```

4. Build and start the application:
   ```
   docker-compose up --build
   ```

5. Access the application:
   - Frontend and Backend API: http://localhost

   The Nginx server acts as a reverse proxy, routing requests to either the frontend or backend service based on the URL path:
   - Requests to `/api/*` are routed to the backend service
   - All other requests are routed to the frontend service

To stop the application, press Ctrl+C in the terminal where docker-compose is running, or run:

## Contributing

We welcome contributions to improve the project. Please read our [CONTRIBUTING.md](CONTRIBUTING.md) for more details.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Continuous Integration

This project uses GitHub Actions for continuous integration. The workflow does the following:

- Builds and tests the Java backend
- Builds and tests the Next.js frontend
- Builds and runs the Docker image

The CI process is triggered on pushes to the `main` branch and on pull requests to the `main` branch.

To see the status of the CI process, check the "Actions" tab in the GitHub repository.

## Releasing a New Version

To release a new version of the application:

1. Ensure you have the necessary permissions to push to the repository and Docker registry.
2. Make the release script executable (you only need to do this once):
   ```
   chmod +x release.sh
   ```
3. Run the release script with the new version number and a commit message:
   ```
   ./release.sh 1.0.0 "Release version 1.0.0 with new feature X and bug fix Y"
   ```
   Replace `1.0.0` with the desired version number and provide a descriptive commit message.

The script will:
- Update version numbers to the release version
- Update CHANGELOG.md
- Commit changes with the provided message and create a git tag
- Push changes and tag to the repository
- Build and push a new Docker image with the release version
- Update version numbers to the next snapshot version (e.g., 1.0.1-SNAPSHOT)
- Commit and push the snapshot version update

This process ensures that after a release, the project is immediately prepared for the next development iteration.
