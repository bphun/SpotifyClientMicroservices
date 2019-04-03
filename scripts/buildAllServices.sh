#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

for service in $(ls services); 
do

    if [ "$service" = "database" ] || [ "$service" = "nginx" ]; then
        continue
    fi

    echo Building $service...

    cd services/$service
    gradle build -x test

    if [ $? -eq 0 ]; then
        printf "${GREEN}Successfully built $service${NC}\n"
    else
        printf "${RED}Build of $service failed${NC}\n"
    fi

    cd ../../

done