package com.demo;

import static jakarta.security.enterprise.identitystore.IdentityStore.ValidationType.PROVIDE_GROUPS;

import java.io.IOException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.security.enterprise.identitystore.openid.OpenIdContext;

@ApplicationScoped
public class AuthorizationIdentityStore implements IdentityStore {
    private static final Logger LOGGER = Logger.getLogger(AuthorizationIdentityStore.class.getName());

    private String email;
    
    private Map<String, Set<String>> authorization;
    
    @PostConstruct
    void init() {
    	LOGGER.config("IdentityStore.init()");
        try {
            var properties = new Properties();
            properties.load(getClass().getResourceAsStream("/oidc.properties"));
            email = properties.getProperty("email", "");
            LOGGER.log(
                    Level.INFO, // TODO maybe change to DEBUG
                    "email: {0}",
                    new Object[] { email });
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load oidc.properties", e);
            email = "";
        }
        authorization = Map.of(
                "user", Set.of("foo", "bar"),
                email,  Set.of("foo", "bar")); // user in Google.
    }
    
	@Inject
    private OpenIdContext context;

    @Override
    public Set<ValidationType> validationTypes() {
        return EnumSet.of(PROVIDE_GROUPS);
    }

    @Override
    public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        var principal = validationResult.getCallerPrincipal().getName();
        LOGGER.log(Level.INFO, "Get principal name in validation result: {0}", principal); // TODO maybe change to DEBUG
        LOGGER.log(Level.INFO, "claims json:" + context.getClaimsJson());
        LOGGER.log(Level.INFO, "provider json:" + context.getProviderMetadata());
        var issuer = context.getProviderMetadata().getString("issuer");
        if (issuer.endsWith("google.com")) { // As Google returns a long numeric user id, we try to use the email address instead
        	var email = context.getClaimsJson().getString("email");
        	return authorization.get(email) == null ? Collections.<String>emptySet() : authorization.get(email);
        } else {
        	return authorization.get(principal) == null ? Collections.<String>emptySet() : authorization.get(principal);
        }
    }
}