package io.github.opendeveloper.social.google.config;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.opendeveloper.social.google.api.impl.GoogleTokenVerifierTemplate;

import java.util.Arrays;

/**
 * Created by sgupta on 1/17/17.
 */

@Configuration
@ConditionalOnClass({GoogleIdentifierProperties.class})
@EnableConfigurationProperties(GoogleIdentifierProperties.class)
public class GoogleIdentifierConfiguration {

    private final GoogleIdentifierProperties googleIdentifierProperties;

    @Autowired
    public GoogleIdentifierConfiguration(GoogleIdentifierProperties googleIdentifierProperties) {
        this.googleIdentifierProperties = googleIdentifierProperties;
    }

    @Bean
    public GoogleIdTokenVerifier googleIdTokenVerifier(JacksonFactory jacksonFactory, HttpTransport httpTransport) {
        return new GoogleIdTokenVerifier.Builder(httpTransport, jacksonFactory)
                .setIssuer(googleIdentifierProperties.getIssuer())
                .setAudience(Arrays.asList(googleIdentifierProperties.getClients()))
                .build();
    }

    @Bean
    public JacksonFactory jacksonFactory() {
        return new JacksonFactory();
    }

    @Bean
    public HttpTransport httpTransport() {
        return new NetHttpTransport();
    }

    @Bean
    public GoogleTokenVerifierTemplate googleTokenVerifierTemplate(GoogleIdTokenVerifier googleIdTokenVerifier) {
        return new GoogleTokenVerifierTemplate(googleIdTokenVerifier);
    }
}
