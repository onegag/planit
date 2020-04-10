FROM hseeberger/scala-sbt:11.0.6_1.3.9_2.13.1 as builder
WORKDIR /myproject
ADD . /myproject
CMD sbt assembly

FROM openjdk:8-jre-alpine
COPY --from=builder target/scala-2.12 target/scala-2.12
EXPOSE 8080
CMD java -jar planit_2.12-1.0.jar"

