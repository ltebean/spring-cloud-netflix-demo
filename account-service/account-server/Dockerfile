FROM openjdk:8-jre-alpine
RUN apk --no-cache add curl
VOLUME /tmp
ADD ./target/account-server-1.0-SNAPSHOT.jar /
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -jar /account-server-1.0-SNAPSHOT.jar
HEALTHCHECK --interval=10s --timeout=5s CMD curl --fail http://localhost:9000/user || exit 1
EXPOSE 9000
