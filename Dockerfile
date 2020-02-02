# Province's Dockerfile 
####################### HOW it works after you clone in local #####################################
#### docker build --tag grestwork-image .
#### docker images
#### docker run -d --name grestwork --publish 27730:30277 --memory 120m --cpu-shares 512 grestwork-image
#### docker logs grestwork
#### docker ps -a
#### open http://localhost:27730/messages/provinces and http://localhost:27730/messages on navigator
#### docker stop grestwork
#### docker start grestwork
#################################################

## Use ubuntu-19.04 as the image OS
#FROM ubuntu:18:04

## Use Java runtime 11 as parent image #openjdk:11-jdk
FROM maven:3.6.3-jdk-11
VOLUME /tmp
 
## Set maintainer email
MAINTAINER juoud1@gmail.com

## Set container's working directory
WORKDIR /app

## Copy project directory content into the container working dir
ADD . /app

## Build and create jar using maven command
RUN mvn clean package -DskipTests=true -Ddir=app -Dspring.profiles.active=docker

## Copy /target content into /app
ADD target/gwebwork.jar grestwork.jar

## Remove app/source directory
# RUN ls -la app/

## Make port 27730 available to the word outside this container
EXPOSE 27730

## Define environment variable
ENV JAV_OPTS="-Dspring.profiles.active=docker"

## Run grestwork.jar when the container launches
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar grestwork.jar"]