FROM openjdk:17
EXPOSE 8010
ADD target/buildlive-companyservice.jar buildlive-companyservice.jar
ENTRYPOINT ["java","-jar","/buildlive-companyservice.jar"]