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