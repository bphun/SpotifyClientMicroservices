#!/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

args=''
brief=''
services=()

if [ "$1" = "-b" ] || [ "$1" = "--build" ]; then
    args='build -x test'
    brief='Build'
elif [ "$1" = "-c" ]|| [ "$1" = "--clean" ]; then
    args='clean'
    brief='Clean'
elif [ "$1" = "-h" ]|| [ "$1" = "--help" ]; then
    printf "%s\n\n" "Usage: buildTools [--help] <build_action> [args]"
    printf "%s\t\t%s\n" "-c --clean [services]" "Clean the specified services in the services/ directory"
    printf "%s\t\t%s\n" "-b --build [services]" "Build the specified services in the services/ directory"
    printf "%s\t\t\t%s\n" "-h --help" "Display this help dialog"
    exit 0
fi

if [ ! -z "$2" ]; then
    shift
    while test ${#} -gt 0
    do
        services+=($1)
        shift
    done
else 
    services=(`exec ls services/`)
fi

for service in ${services[*]}; 
do

    if [ "$service" = "database" ] || [ "$service" = "nginx" ]; then
        continue
    fi

    echo $brief $service...
    
    cd services/$service
    gradle $args

    if [ $? -eq 0 ]; then
        printf "${GREEN}$brief of $service successful${NC}\n"
    else
        printf "${RED}$brief of $service failed${NC}\n"
    fi

    cd ../../

done
