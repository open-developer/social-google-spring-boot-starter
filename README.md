# Spring Boot Starter Social Google Identifer

Example implementation of a Spring Boot starter project that auto-configures a Google Id token verifier for server 
side verification

Projects:

- Starter Project
- Sample Application

## Usage

The `social-google-spring-boot-starter` is a Spring Boot application that allows users authenticate google token and access user information.

To get started, replace/add the google client id and issuer (if not similar to default) in application.yml

    spring.social.google.clients=client1,client2,client3
    spring.social.google.issuer=https://accounts.google.com
    
Add GoogleIdTokenVerifierTemplate class as dependency:
    @Autowired
    GoogleIdTokenVerifierTemplate googleIdTokenVerifierTemplate;
    
Get the GoogleIdToken object after verification with the google identifier service

GoogleIdToken googleIdToken = googleIdTokenVerifierTemplate.verify(idToken.getIdToken());