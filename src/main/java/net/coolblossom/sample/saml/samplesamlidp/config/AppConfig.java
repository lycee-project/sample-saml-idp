package net.coolblossom.sample.saml.samplesamlidp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.provider.SamlServerConfiguration;

@Configuration
@ConfigurationProperties(prefix = "spring.security.saml2")
public class AppConfig extends SamlServerConfiguration {
}
