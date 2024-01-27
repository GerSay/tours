package gersay.tours.config;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@Configuration
@EnableWebSecurity
public class OAuth2Config {
    @Value("${oauth2.clientid}")
    private String clientid;

    @Value("${oauth2.clientSecret}")
    private String clientSecret;

    @Value("${oauth2.accessTokenUri}")
    private String accessTokenUri;

    @Value("${oauth2.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${oauth2.redirectUri}")
    private String redirectUri;

    @Bean
    public OAuth2ProtectedResourceDetails oauth2ProtectedResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("read", "write"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        return details;
    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(oauth2ProtectedResourceDetails(), oauth2ClientContext);
    }
}
