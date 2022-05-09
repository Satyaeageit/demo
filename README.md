# demo - how to run
1. Import project as maven project in loal eclipse, build the pom.xml and run the application.
2. server.port=8080 defined in application.properties, change if you want to run on any other port.
3. you can also run the code with following command
java -jar target/demo-0.0.1-SNAPSHOT.jar -Xms256m -Xmx512m -XX:+UseG1GC

4. API to generate the list of random integer is http://localhost:8080/api/query/geneate
run it from postman, no input needed, it will return 2 integers in a array.

5. Api to validate the sum result is http://localhost:8080/api/query/validate
   below is the input which need to be provided while calling the api : 
    {
           "result": 120,
           "randomNumL": [
               34,
               86
           ]
    }
   
t
