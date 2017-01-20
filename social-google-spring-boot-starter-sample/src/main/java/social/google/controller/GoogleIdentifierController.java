package social.google.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import social.google.GoogleIdTokenVerifierTemplate;
import social.google.model.Token;
import social.google.model.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static java.util.Objects.isNull;

/**
 * Created by sgupta on 1/18/17.
 */
@RestController
public class GoogleIdentifierController {

    private GoogleIdTokenVerifierTemplate googleIdTokenVerifierTemplate;

    @Autowired
    public GoogleIdentifierController(GoogleIdTokenVerifierTemplate googleIdTokenVerifierTemplate) {
        this.googleIdTokenVerifierTemplate = googleIdTokenVerifierTemplate;
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public User verifyToken(@RequestBody Token idToken) throws GeneralSecurityException, IOException {
        GoogleIdToken googleIdToken = googleIdTokenVerifierTemplate.verify(idToken.getIdToken());
        if (isNull(googleIdToken)) {
            throw new RuntimeException("Unauthenticated User by google");
        }
        GoogleIdToken.Payload payload = googleIdToken.getPayload();
        return new User((String) payload.get("given_name"), (String) payload.get("family_name"));
    }
}
