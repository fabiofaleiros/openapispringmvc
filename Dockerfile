FROM maven:3.8.4-openjdk-11-slim AS builder

WORKDIR /app

# Copy source code to container
COPY . .

# Compile source code and generate deliverables
RUN mvn clean package

FROM tomcat:9.0.33-jdk11-openjdk-slim

# Clean tomcat root in webapps directory
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]

# Copy hello.war to tomcate webapps directory
COPY --from=builder /app/war/target/hello.war /usr/local/tomcat/webapps/ROOT.war

# Run tomcat
CMD ["catalina.sh", "run"]
