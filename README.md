# Spring Boot Starter Social Google Identifer

Example implementation of a Spring Boot starter project that auto-configures a Google Id token verifier for server 
side verification

Projects:

- Starter Project
- Sample Application

## Usage

The `social-google-spring-boot-starter` is a Spring Boot application that allows users authenticate google token and access user information.

To get started, replace/add the google client id and issuer (if different from default (https://accounts.google.com))
 in application.yml

    spring.social.google.clients=client1,client2,client3
    spring.social.google.issuer=https://accounts.google.com
    
Add GoogleTokenVerifierTemplate class as dependency. Get the GoogleIdToken object after verification with the google
 identifier service

    GoogleIdToken googleIdToken = googleTokenVerifierTemplate.verify(idToken.getIdToken());

##### To run sample

After replacing the configuration properties with valid client ids, start the application using `mvn spring-boot:run`. 
This will start a web application on [http://localhost:8080]()

Get the valid google authorized id token. Send the post request, see below.

Request
    
    POST  http://localhost:8080/verify
    {
        "idToken":"token string"
    }
    
Response

    {
        "givenName":"Alex" ,
        "familyName":"Miller"
    }