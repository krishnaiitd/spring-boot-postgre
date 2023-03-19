# To run the Application
#### Clean install, will delete the previous jar and install new jar at target dir.
#### Create jar
> mvn clean install
[INFO] --- install:3.0.1:install (default-install) @ postgre ---
[INFO] Installing /Users/krishna/Library/CloudStorage/OneDrive-Personal/krishna/projects/upwork/raj/postgre/pom.xml to /Users/krishna/.m2/repository/com/example/postgre/postgre/0.0.1-SNAPSHOT/postgre-0.0.1-SNAPSHOT.pom
[INFO] Installing /Users/krishna/Library/CloudStorage/OneDrive-Personal/krishna/projects/upwork/raj/postgre/target/postgre-0.0.1-SNAPSHOT.jar to /Users/krishna/.m2/repository/com/example/postgre/postgre/0.0.1-SNAPSHOT/postgre-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
#### To the application 
>java -jar target/postgre-0.0.1-SNAPSHOT.jar
2023-03-14T23:08:24.168+09:00  WARN 6662 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2023-03-14T23:08:24.496+09:00  INFO 6662 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-03-14T23:08:24.503+09:00  INFO 6662 --- [           main] c.e.postgre.postgre.PostgreApplication   : Started PostgreApplication in 2.475 seconds (process running for 2.84)


#### If you want to run the 'existing jar' with different port number on your machine then it can be done without 
#### changing anything on code, and we can use to the existing jar as well
> java -Dserver.port=8081 -jar target/postgre-0.0.1-SNAPSHOT.jar

#### To check the application successfully shutdown or not 
#### To look for the port number
> ps aux | grep 8081
krishna@Krishnas-MacBook-Pro postgre % ps aux | grep 8081
krishna           6819   0.0  1.2 40165912 200776 s003  T    11:11PM   0:07.31 java -Dserver.port=8081 -jar target/postgre-0.0.1-SNAPSHOT.jar
krishna           7393   0.0  0.0 34130544    656 s003  S+   11:14PM   0:00.00 grep 8081
> 

> sudo kill 6819