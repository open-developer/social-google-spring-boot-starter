package social.google.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;

import static java.util.Objects.isNull;

/**
 * Created by sgupta on 1/17/17.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.social.google")
public class GoogleIdentifierProperties {

    @Nonnull
    private String [] clients;

    @Nonnull
    private String issuer;

    public String[] getClients() {
        return clients;
    }

    public void setClients(String[] clients) {
        this.clients = clients;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @PostConstruct
    public void init() {
        if(isNull(issuer)) {
            issuer = "https://accounts.google.com";
        }
    }
}
