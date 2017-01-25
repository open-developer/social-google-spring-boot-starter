package io.github.opendeveloper.social.google.model;

/**
 * Created by sgupta on 1/19/17.
 */
public class User {

    private String givenName;
    private String familyName;

    public User(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
