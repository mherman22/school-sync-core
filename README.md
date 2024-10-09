# Mbarara Girls Management System (MGMS)

This is a comprehensive school management system built with Next.js for Mbarara Girls School.

## Getting Started

First, run the development server:

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `app/page.tsx`. The page auto-updates as you edit the file.

This project uses [`next/font`](https://nextjs.org/docs/app/building-your-application/optimizing/fonts) to automatically optimize and load [Geist](https://vercel.com/font), a new font family for Vercel.

## Learn More

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.

You can check out [the Next.js GitHub repository](https://github.com/vercel/next.js) - your feedback and contributions are welcome!

## Deploy on Vercel

The easiest way to deploy your Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme) from the creators of Next.js.

Check out our [Next.js deployment documentation](https://nextjs.org/docs/app/building-your-application/deploying) for more details.

## Project Structure and Routing

The application uses Next.js's file-based routing system. Here's an overview of the main routes:

- `/` - Home page (redirects to login)
- `/login` - User login page
- `/register` - User registration page
- `/dashboard` - Main dashboard (redirects to overview)
  - `/dashboard/overview` - Overview of key statistics
  - `/dashboard/reports` - Generate and view reports
  - `/dashboard/timetables` - Manage school timetables
  - `/dashboard/teachers` - Manage teacher information
  - `/dashboard/circular` - Create and print circulars
  - `/dashboard/finance` - Manage school finances
  - `/dashboard/dispensary` - Manage school health services
  - `/dashboard/dormitory` - Manage student accommodations

Each of these routes corresponds to a file in the `src/app` directory structure.

## Running with Docker

To run the application using Docker, follow these steps:

1. Make sure you have Docker installed on your system.

2. Build the Docker image:
   ```
   docker build -t mgms-app .
   ```

3. Run the container:
   ```
   docker run -p 3000:3000 mgms-app
   ```

4. Open [http://localhost:3000](http://localhost:3000) in your browser to access the application.

Alternatively, if you have Docker Compose installed, you can use:

```
docker-compose up --build
```

This will build and run your application.

## Continuous Integration

This project uses GitHub Actions for continuous integration. The workflow does the following:

- Runs on every push to the `main` branch and on pull requests to the `main` branch
- Sets up a Node.js environment
- Installs dependencies
- Runs the linter
- Builds the application
- Runs tests (when implemented)
- Builds and runs the Docker image

You can see the workflow runs in the "Actions" tab of the GitHub repository.
