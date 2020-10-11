FROM openjdk:13
WORKDIR /app/
COPY ./* ./
RUN javac P1.java
