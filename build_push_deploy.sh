#!/bin/bash
CLUSTER_NAME="cluster2"
PROCESS_NAME="ecsService3"
echo "Starting build, push and deploy to cluste: " $CLUSTER_NAME " process: " $PROCESS_NAME
gradle build docker
docker image rm springio/dev-helper-api
docker image rm 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
gradle build docker
docker tag springio/dev-helper-api:latest 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
docker push 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
aws ecs update-service --cluster $CLUSTER_NAME --service $PROCESS_NAME --force-new-deployment
echo "Pushed container"