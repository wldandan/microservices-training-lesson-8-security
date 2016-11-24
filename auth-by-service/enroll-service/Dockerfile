FROM java:8

RUN mkdir /app
WORKDIR /app

ADD build/libs/enroll-service-0.0.1-SNAPSHOT.jar /app
RUN ln -sf enroll-service-0.0.1-SNAPSHOT.jar enroll-service-latest.jar

CMD java -jar enroll-service-latest.jar --server.port=80