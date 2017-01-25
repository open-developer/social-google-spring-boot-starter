package io.github.opendeveloper.social.google.api;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by sgupta on 1/24/17.
 */
public interface GoogleTokenVerifier {

    GoogleIdToken verify(String idToken) throws GeneralSecurityException, IOException;

    boolean verify(GoogleIdToken googleIdToken) throws GeneralSecurityException, IOException;

    boolean verify(IdToken idToken);
}
