# Contributing to School Sync

Thank you for your interest in contributing to School Sync! We welcome contributions of all kinds, from bug reports to feature requests, and, of course, code contributions. This guide will help you get started with contributing to our project.

## Table of Contents
1. [Code of Conduct](#code-of-conduct)
2. [How to Contribute](#how-to-contribute)
3. [Getting Started](#getting-started)
4. [Submitting Changes](#submitting-changes)
5. [Style Guidelines](#style-guidelines)
6. [Reporting Issues](#reporting-issues)
7. [Additional Resources](#additional-resources)

## Code of Conduct

This project adheres to the [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md). By participating, you are expected to uphold this code. Please report unacceptable behavior to [hermanmuhereza22@gmail.com](mailto:hermanmuhereza22@gmail.com).

## How to Contribute

There are several ways you can contribute to School Sync:

- **Reporting Bugs**: Help us improve by identifying and reporting issues.
- **Suggesting Enhancements**: Have an idea to make School Sync better? Let us know!
- **Code Contributions**: Help fix issues or add new features.
- **Documentation**: Help us improve our documentation.
- **Testing**: Help us test new features and ensure the stability of the application.
- **Translations**: Contribute to making School Sync accessible in multiple languages.

## Getting Started

1. **Fork the repository**:
   - Click on the "Fork" button at the top right corner of the [School Sync repository](https://github.com/HermanMuhereza/school-sync-core).
   
2. **Clone your fork**:
   ```bash
   git clone https://github.com/your-username/school-sync-core.git
   cd school-sync-core
   ```
   
3. **Set up the project**:
   - Follow the instructions in the `README.md` to install dependencies and set up the project on your local machine.
   - Make sure you have Java 11+ and Maven installed.
   - Install the required dependencies:
     ```bash
     mvn clean install
     ```
   - For the frontend, ensure you have Node.js and npm installed, then:
     ```bash
     cd frontend
     npm install
     ```
   
4. **Create a new branch**:
   - Use a meaningful name for your branch, such as `feature/new-feature` or `bugfix/issue-number`.
   ```bash
   git checkout -b branch-name
   ```

## Submitting Changes

1. **Make your changes**:
   - Ensure that your changes adhere to our [Style Guidelines](#style-guidelines).
   - Write tests for new features or bug fixes.
   
2. **Commit your changes**:
   - Write clear and descriptive commit messages.
   ```bash
   git add .
   git commit -m "Description of changes"
   ```
   
3. **Push to your fork**:
   ```bash
   git push origin branch-name
   ```

4. **Open a Pull Request**:
   - Go to the [School Sync repository](https://github.com/HermanMuhereza/school-sync-core) on GitHub, navigate to the "Pull Requests" tab, and click "New Pull Request".
   - Please include a detailed description of the changes you've made and reference any related issues.
   - Ensure that your PR passes all automated checks and tests.

## Style Guidelines

- **Java Code**: We use Google Java Format through Spotless. The formatting is automatically applied when you build the project using Maven. You can also manually format your code by running:  ```bash
  mvn spotless:apply  ```
  The build will fail if the code is not properly formatted, ensuring consistent style across the project.
- **TypeScript/React**: We use Prettier for formatting. You can format your code by running:  ```bash
  cd frontend
  npm run format  ```
- **Linting**: For the frontend, you can run the linter with:  ```bash
  cd frontend
  npm run lint  ```
  To automatically fix linting issues, run:  ```bash
  cd frontend
  npm run lint:fix  ```
- **Commit Messages**: Use clear and concise language, and prefix messages with tags like `fix`, `feat`, or `docs`.
- **Documentation**: Any new features or changes should include updates to relevant documentation files.

## Reporting Issues

If you find a bug or have a suggestion for improvement, please report it by [opening a new issue](https://github.com/HermanMuhereza/school-sync-core/issues/new) and include as much detail as possible:
- Steps to reproduce the issue
- Expected and actual behavior
- Screenshots, if applicable
- Any relevant logs or error messages
- Your environment details (OS, Java version, Node.js version, etc.)

## Additional Resources

- **Project Documentation**: Check our [docs](docs/) folder for detailed documentation.
- **API Reference**: [API.md](docs/API.md)
- **Frequently Asked Questions**: [FAQ.md](docs/FAQ.md)
- **Development Setup Guide**: [DEVELOPMENT.md](DEVELOPMENT.md)

Thank you for contributing to School Sync! Your efforts make this project better for students, teachers, and educational institutions worldwide.

---

If you have any questions or need further assistance, don't hesitate to reach out to the maintainers or open a discussion on our GitHub repository.
