FROM bellsoft/liberica-openjdk-alpine:11

RUN apk add jq

RUN apk add curl 

WORKDIR /home/selenium-docker

ADD target/docker-resources		./

ADD runner.sh	                runner.sh

ENTRYPOINT sh runner.sh