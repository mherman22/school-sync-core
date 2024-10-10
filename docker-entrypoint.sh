#!/bin/bash
set -e

# Run Liquibase update
/opt/liquibase/liquibase \
    --changeLogFile=/liquibase/changelog/db.changelog-master.xml \
    --url=${SPRING_DATASOURCE_URL} \
    --username=${SPRING_DATASOURCE_USERNAME} \
    --password=${SPRING_DATASOURCE_PASSWORD} \
    update

# Start Tomcat
catalina.sh run
