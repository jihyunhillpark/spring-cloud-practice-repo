# How to run and test user-service project
</br>
1. Run _section1 eureka server_ -[section1.discovery-service](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/main/service-discovery/discovery-service)
</br>
2. Run one of micro services, user-service - [user-service](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/main/e-commerce-practice/user-service)
</br>
3. Open a browser(e.g.chrome) and go to eureka dashboard(127.0.0.1:8761)
</br>
4. In `Instnces currently registered with Eureka` part of dashboard, you can open the link, which stands for user-service. Then, check the port of the user-service in URL address newly opened.  
</br>
5. With that specific port, make a request!! (Postman, Talend API Tester can be helpful)   
`
 
