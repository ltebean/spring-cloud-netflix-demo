FROM openjdk:8-jre-alpine
ADD ./target/account-web-1.0-SNAPSHOT.jar /
RUN apk add --update --no-cache bind-tools

CMD ["java", "-Xmx200m", "-jar", "/account-web-1.0-SNAPSHOT.jar"]

EXPOSE 8080