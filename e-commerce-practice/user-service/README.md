# How to run and test user-service project


1. Run <u>_section1 eureka server_</u> - [section1.discovery-service](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/main/service-discovery/discovery-service)
</br>

2. Run one of micro services, user-service - [user-service](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/main/e-commerce-practice/user-service)
</br>

3. Open a browser(e.g.chrome) and go to eureka dashboard(127.0.0.1:8761)
</br>

4. In `Instances currently registered with Eureka`, part of dashboard, you can open the link which stands for user-service. Then, check the host address and port of the user-service in the URL newly opened.  
</br>

5. With that specific port, make a request!! (Postman, Talend API Tester can be helpful)   
   <img width="902" alt="API call example" src="https://github.com/jihyunhillpark/spring-cloud-practice-repo/assets/29705409/d6b34ca1-5c62-4252-adbd-8af620cd0ba1">
   * _you can also check whether it genuinely works or not by looking into DB! h2-console(endpoint ) will be of great help!_
