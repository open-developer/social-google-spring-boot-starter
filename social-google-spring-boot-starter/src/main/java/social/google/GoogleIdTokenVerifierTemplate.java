package social.google;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by sgupta on 1/19/17.
 */
@Component
public class GoogleIdTokenVerifierTemplate {

    private GoogleIdTokenVerifier googleIdTokenVerifier;

    public GoogleIdTokenVerifierTemplate(GoogleIdTokenVerifier googleIdTokenVerifier) {
        this.googleIdTokenVerifier = googleIdTokenVerifier;
    }

    public GoogleIdToken verify(String idToken) throws GeneralSecurityException, IOException {
        return googleIdTokenVerifier.verify(idToken);
    }

    public boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException {
        return googleIdTokenVerifier.verify(googleIdToken);
    }

    public boolean verify(IdToken idToken) {
        return googleIdTokenVerifier.verify(idToken);
    }
}
