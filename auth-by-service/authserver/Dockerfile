FROM java:8

RUN mkdir /app
WORKDIR /app

ADD ./filebeat/wait-for-it.sh /usr/local/bin/wait-for-it
RUN chmod +x /usr/local/bin/wait-for-it

ADD build/libs/auth-server-0.0.1-SNAPSHOT.jar /app
RUN ln -sf auth-server-0.0.1-SNAPSHOT.jar authserver-latest.jar

CMD java -jar authserver-latest.jar --server.port=443