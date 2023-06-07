FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TZ=Asia/Seoul
ENV	USE_PROFILE=linux
ENTRYPOINT ["java","-jar","-Djasypt.encryptor.password=mealkitislove","/app.jar"]
<<<<<<< HEAD
#ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${USE_PROFILE}","/japsswa-0.0.1-SNAPSHOT.jar"]
=======

>>>>>>> branch 'KSM' of https://github.com/stuover/JSS.git
