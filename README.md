# Mbarara Girls Secondary School Core System

This project contains both the backend (Java Spring) and frontend (Next.js) for the Mbarara Girls Secondary School Management System.

## Running with Docker Compose

To run the entire application (backend, frontend, database, and Nginx) using Docker Compose:

1. Make sure you have Docker and Docker Compose installed on your system.

2. Clone this repository:
   ```
   git clone https://github.com/your-username/mbarara-girls-ss-core.git
   cd mbarara-girls-ss-core
   ```

3. Build and start the application:
   ```
   docker-compose up --build
   ```

4. Access the application:
   - Frontend and Backend API: http://localhost

   The Nginx server acts as a reverse proxy, routing requests to either the frontend or backend service based on the URL path:
   - Requests to `/api/*` are routed to the backend service
   - All other requests are routed to the frontend service

To stop the application, press Ctrl+C in the terminal where docker-compose is running, or run:

## Contributing

We welcome contributions to improve the project. Please read our [CONTRIBUTING.md](CONTRIBUTING.md) for more details.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

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
3. Run the release script with the new version number:
   ```
   ./release.sh 1.0.0
   ```
   Replace `1.0.0` with the desired version number.

The script will:
- Update version numbers to the release version
- Update CHANGELOG.md
- Commit changes and create a git tag
- Push changes and tag to the repository
- Build and push a new Docker image with the release version
- Update version numbers to the next snapshot version (e.g., 1.0.1-SNAPSHOT)
- Commit and push the snapshot version update

This process ensures that after a release, the project is immediately prepared for the next development iteration.
