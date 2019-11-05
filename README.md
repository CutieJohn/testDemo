# testDemo


--------------------------------- How to run -----------------------------
How to run this demo app:
    Method #1:
        Add this project as a Maven project. After this system solves all dependencies, locate to DemoApplication and run DemoApplication.class
    Method #2:
        a. Locate and find the jar package: /package/demo.jar;
        b. Open terminal window at this path, and type "java -jar demo.jar" then press Enter in terminal window
        
Use APIs via Swagger:
    a. Before you run this app, make sure that port 8080 is not in use;
    b. After start up the app, go to http://localhost:8080/swagger-ui.html to open the Swagger index;
    c. Start using the APIs;
    d. You can use the mock data listed below.
    
Run test units:
    a. Start up the app via method #1 or #2;
    b. Locate to class /test/java/com.john.demo/DemoTest.class
    c. Run the 2 test cases.
    

Backend:
    Technology stack:
        JDK 1.8
        SpringBoot
        RESTful API
        Swagger Documentation
        Unit Testing using JUnit
    Mock data:
        Accounts:
            #1:{
                   "accountId": 1,
                   "userId": 1001,
                   "balance": 1000,
                   "cardNo": "2859382746585976123",
                   "name": "John",
                   "enabled": true
                 }
             #2:{
                    "accountId": 2,
                    "userId": 1002,
                    "balance": 1000,
                    "cardNo": "2859382746585976124",
                    "name": "Jane",
                    "enabled": true
                  }
                 
Error code and message:
    System:
        0, success
    Card:
        1001, Invalid card number
        1002, Card is disabled
        1003, Card does not exists    
    Account:
        2001, Balance is not enough
        
Return data map:
    a. Status codes:
        200: ok
        100: error
        -1: deprecated
        -2: hystrix fallback
    b. errCode: error code such as 1001/1002..
    c. errMsg: error description
    d. body: result data body
    #Example:
        {
          "status": 200, // success
          "errCode": 0, // system error code
          "errMsg": "",  // error message
          "body": {      // result data body
            "accountId": 2,
            "userId": 1002,
            "balance": 1000,
            "cardNo": "2859382746585976124",
            "name": "Jane",
            "enabled": true
          }
        }
        
3rd Party Libraries:
    a. junit : for unit test
    b. alibaba.fastjson : for json object parse
    c. swagger: for swagger