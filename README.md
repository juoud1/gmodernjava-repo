# General modern Java
This project counts many branches such as :
- master contains some sample of java 11 based maven and spring boot 2.2.
So it uses Spring ApplicationRunner to run some sample of new java API like as Objects, List.of, etc.
- featureJava11RestfulSpringBoot is the default branch that show a little sample of spring Restful service.
Three profiles are defined dev, qa and docker to allow you to ready test the application.

# Profile "docker" : how it works 
1. clone the project : for more information https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-clone
2. Checkout branch "featureJava11RestfulSpringBoot"
3. Build the image: 
   $ docker build --tag grestwork-image .
4. Get all images :
   $ docker images
5. Run the image (example) :
   $ docker run -d --name grestwork --publish 27730:30277 --memory 120m --cpu-shares 512 grestwork-image
6. View the log of running container :
   $ docker logs grestwork
7. Vill all containers created :
   $ docker ps -a
8. Access the service with postman or navigator :
   Open http://localhost:27730/messages/provinces and http://localhost:27730/messages
9. Can stop the container :
   $ docker stop grestwork
10. Can start the container :
   $ docker start grestwork

# Shutdown the application
Use the following curl command : 
$ curl -X POST localhost:27730/messages/shutdownApp
