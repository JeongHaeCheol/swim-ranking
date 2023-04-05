FROM adoptopenjdk/openjdk11
WORKDIR /usr/src/app
ARG JAR_PATH = ./build/libs
COPY ${JAR_PATH}/swim-ranking-0.0.1-SNAPSHOT.jar ${JAR_PATH}/swim-ranking-0.0.1-SNAPSHOT.jar
CMD java -jar ${JAR_PATH}/swim-ranking-0.0.1-SNAPSHOT.jar