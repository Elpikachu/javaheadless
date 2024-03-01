## Demo template for Java backend and React frontend

### Stack
- Java 17 for the backend
- NodeJs 20 for the frontend
- Mariadb 11.2 as a database service

## Projects
- Platform.sh: https://console.platform.sh/solutions/iw5anthvyckli
- Upsun: https://console.upsun.com/solutions/lydmjrme2cfb6

### Backend
It's a Spring boot application used to provide an API.

The backend is relying on Maven as a package manager. As the default maven version provided isn't the most up-to-date, we download it as part of the build hook.

In order to work properly independing on the environment used, we are using a .environment file to handle most of the variables related to the configuration of the application.
As we want the demo to run smoothly, the data for the application is imported from CSV files, which paths are also provided in this file.

This backend exposes 3 endpoints:
- Writers: for the authors
- Content: for the content
- Resources: for the images

### Frontend
It's a React application used as a client to the API.

The frontend is relying on NPM as a package manager.
In order to work properply independing of the environment used, we are using a .environment file to handle the backend URL.

### Local build
In order to get the application working locally, you can use the docker-composer file included to get the DB service running and will need to update the .environment files to reflect your local environment.

### Contribution
- Maintainer: @julien.khamis