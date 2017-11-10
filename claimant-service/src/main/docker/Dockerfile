FROM anapsix/docker-oracle-java8
VOLUME /tmp
ADD claimant-service-0.1.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]