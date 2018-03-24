package br.com.edsontofolo.webchat.chat.listener;

import br.com.edsontofolo.webchat.chat.util.ActiveSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Listener for spring security login success event.
 *
 * @author Yasitha Thilakaratne
 */
@Component
public class LoginEventListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Autowired
    private ActiveSessionManager activeSessionManager;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        activeSessionManager.add(event.getAuthentication().getName());
    }
}
