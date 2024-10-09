# Mbarara Girls Secondary School Core System

This project contains both the backend (Java Spring) and frontend (Next.js) for the Mbarara Girls Secondary School Management System.

## Running with Docker Compose

To run the entire application (backend, frontend, and database) using Docker Compose:

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
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080

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
   ./release.sh 1.0.1
   ```
   Replace `1.0.1` with the desired version number.

The script will update version numbers, commit changes, create a git tag, push changes to the repository, and build and push a new Docker image.
