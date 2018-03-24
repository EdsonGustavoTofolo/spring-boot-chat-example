package br.com.edsontofolo.webchat.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

/**
 * Created by Edson on 21/03/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public final static String USER_ROLE_CHAT_USER = "CHAT-USER";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.inMemoryAuthentication().withUser("Nio").password("{noop}nio").roles(USER_ROLE_CHAT_USER);
        authBuilder.inMemoryAuthentication().withUser("Jason").password("{noop}jason").roles(USER_ROLE_CHAT_USER);
        authBuilder.inMemoryAuthentication().withUser("Lana").password("{noop}lana").roles(USER_ROLE_CHAT_USER);
        authBuilder.inMemoryAuthentication().withUser("Max").password("{noop}max").roles(USER_ROLE_CHAT_USER);
        authBuilder.inMemoryAuthentication().withUser("Joe").password("{noop}joe").roles(USER_ROLE_CHAT_USER);
        authBuilder.inMemoryAuthentication().withUser("Mike").password("{noop}mike").roles(USER_ROLE_CHAT_USER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access(getSecurityAccessCheckString(USER_ROLE_CHAT_USER))
                .and().formLogin().loginPage("/msg-forward/chatbot")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/msg-forward/chatbot")
                .and().logout().logoutSuccessUrl("/msg-forward/chatbot");
        http.sessionManagement()
                .maximumSessions(1).sessionRegistry(sessionRegistry());
        http.csrf().disable();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public static String getSecurityAccessCheckString(String role) {
        return "hasRole('" + role + "')";
    }
}
