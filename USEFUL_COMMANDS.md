# Useful commands

## Add extensions to gradle project
```bash
./gradlew addExtension --extensions="spring-data-jpa"
./gradlew addExtension --extensions="org.jboss.logmanager:log4j2-jboss-logmanager,quarkus-logging-json"
./gradlew addExtension --extensions="hibernate-validator"
```

## Run in dev mode
```bash
./gradlew quarkusDev
```

## Test project
```bash
./gradlew test
firefox --new-tab build/reports/tests/test/index.html 
```

## Add Lombok to gradle project
Add to build.gradle file
```
compileOnly 'org.projectlombok:lombok:1.18.16'
annotationProcessor 'org.projectlombok:lombok:1.18.16'	
testCompileOnly 'org.projectlombok:lombok:1.18.16'
testAnnotationProcessor 'org.projectlombok:lombok:1.18.16'
```

## Links
https://quarkus.io/guides/spring-data-jpa
https://quarkus.io/guides/validation
