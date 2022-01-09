FROM java:8
VOLUME /tmp
EXPOSE 8082
ADD /build/libs/medicalnotes-1.0.0.jar medicalnotes-1.0.0.jar
ENTRYPOINT ["java","-jar","medicalnotes-1.0.0.jar"]