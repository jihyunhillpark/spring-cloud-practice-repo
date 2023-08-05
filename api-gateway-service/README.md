# API Gateway Service

| section     | commit                                                                                                                | 내용                                                                                                         |
|-------------|-----------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
|  section2-1 | [8bfae2b](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/8bfae2b11f7e2bf71361f9c138a16fa5cfda2fa7) | 두 개의 서비스가 존재하고(localhost:8001 & 8002), client가 api gateway(localhost:8000)를 통해서 접근한다.<br /> `localhost:8000/first-service/welcome -> localhost:8001/welcome`<br />`localhost:8000/second-service/welcome -> localhost:8002/welcome` |
|  section2-2 | [bce24db](https://github.com/jihyunhillpark/spring-cloud-practice-repo/tree/bce24db2cc19721b375a1e2d4982958d9c451acf) | section2-1 기능에 pre-filter, post-filter를 적용해본다. request-header, response-header에 값을 싣어 보낸다<br /> `localhost:8000/first-service/message -> localhost:8001/first-service/message`<br />`localhost:8000/second-service/message -> localhost:8002/second-service/message` |

