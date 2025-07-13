FROM openJDK:17
EXPOSE 8080
ADD target/springboot_deep_dive.jar springboot_deep_dive.jar
LABEL authors="swath"

ENTRYPOINT ["java","-jar", "/springboot_deep_dive.jar"]