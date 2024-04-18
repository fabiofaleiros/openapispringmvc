FROM tomcat:9.0.33-jdk11-openjdk-slim

RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./war/target/hello.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]