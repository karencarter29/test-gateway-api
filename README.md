# test-gateway-api

For run the application do the follows:

* Run the EurekaServerApplication.java, PersonServiceApplication.java, HelloServiceApplication.java and ZuulServiceApplication.java;
* Open your browser;
* Go to http://localhost:8762/ to open Eureka Dashboard. Make sure that all the services are registered;
* Then go to http://localhost:8081/ to open the Person Service start page and make sure that it is working properly
  (also you can try other mappings that you can discover in [Person Controller](https://github.com/karencarter29/test-gateway-api/tree/main/person-service/src/main/java/com/example/personservice/web/controllers));
* Go to http://localhost:8082/ to open the Hello Service start page ([other mappings](https://github.com/karencarter29/test-gateway-api/tree/main/hello-service/src/main/java/com/example/helloservice/web/controllers));
* Go to http://localhost:8083/person. You should see the same page as if you went to http://localhost:8081;
* Go to http://localhost:8083/hello. You should see the same page as if you went to http://localhost:8082;
* Go to http://localhost:8083/person/people. You should see the list of Spanner database recordings.
  (For this step your Google Platform Account should be connected to Spanner Cloud database connection to which is configured in this [file](https://github.com/karencarter29/test-gateway-api/blob/main/person-service/src/main/resources/application.properties));
* Choose any id from recordings list and go to http://localhost:8083/person/hello/[chosen id]. You should see greating of person you choosed from database table.

All this steps should show together work of follows techniligies:

* Eureka Server;
* Zuul Gateway API (for the ability to call all services from one place);
* Feign Client (for the ability to use some functionality of one service into another);
* Spanner Cloud Database.
