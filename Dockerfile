# FROM adoptopenjdk/openjdk11
# WORKDIR {jar파일과 필요한 파일들이 있는 경로}
# COPY {jar파일명}.jar .
# COPY {앱 실행에 필요한 파일} .
# CMD java -jar {jar파일명}.jar

FROM amazoncorretto:11

WORKDIR .

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/swim-ranking-0.0.1-SNAPSHOT ${JAR_PATH}/swim-ranking-0.0.1-SNAPSHOT

CMD ["java","-jar","./build/libs/swim-ranking-0.0.1-SNAPSHOT"]
