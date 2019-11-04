# dev-helper-api

requires:
- gradle (from) 4.4
- java 1.8
- docker

BUILD APP:
build: gradle build
prepare docker container: gradle docker

RUN APP:
run app local: gradle bootRun
run jar: gradle build && java -jar build/libs/dev-helper-api.jar
run app in docker: docker run -p 8080:8080 springio/dev-helper-api



PUSH CONTAINER:
login aws / ecr
aws ecr get-login
remove "e none" from result above outcome. and run

list images: docker images
tag and release:
docker tag springio/dev-helper-api:latest 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper
docker push 289802917946.dkr.ecr.ap-southeast-2.amazonaws.com/dev-helper


login/ssh:
add key pair while starting instance
ssh -i "aws_prive" ec2-user@ec2-54-252-252-57.ap-southeast-2.compute.amazonaws.com


LOGS:
logs: docker logs 4d0fa4454879

current url: ec2-54-252-252-57.ap-southeast-2.compute.amazonaws.com