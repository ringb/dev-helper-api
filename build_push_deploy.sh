echo "Starting build and push.."
gradle build docker
docker image rm springio/dev-helper-api
docker image rm 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
gradle build docker
docker tag springio/dev-helper-api:latest 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
docker push 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
aws ecs update-service --cluster cluster2 --service process3 --force-new-deployment
echo "Pushed container"