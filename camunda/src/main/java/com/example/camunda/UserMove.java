package com.example.camunda;

import com.example.camunda.entity.UserCam;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserMove implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String uri = "http://localhost:8082/users/save";
        RestTemplate restTemplate = new RestTemplate();
        String login = (String) delegateExecution.getVariable("login");
        String password = (String) delegateExecution.getVariable("password");
        restTemplate.postForObject(uri,new UserCam(null, login,password), UserCam.class);
    }
}
