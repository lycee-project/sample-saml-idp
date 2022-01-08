package net.coolblossom.sample.saml.samplesamlidp.config;

import org.springframework.beans.factory.wiring.BeanConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.saml.provider.SamlServerConfiguration;
import org.springframework.security.saml.provider.identity.config.SamlIdentityProviderServerBeanConfiguration;

@Configuration
public class BeanConfig extends SamlIdentityProviderServerBeanConfiguration {

    private final AppConfig appConfig;

    public BeanConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    protected SamlServerConfiguration getDefaultHostSamlServerConfiguration() {
        return this.appConfig;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
