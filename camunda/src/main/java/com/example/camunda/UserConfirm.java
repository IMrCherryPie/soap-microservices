package com.example.camunda;

import com.soap.gen.User;
import com.soap.gen.UserResponse;
import com.soapclient.RequestExecutor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserConfirm implements JavaDelegate {

    @Autowired
    RequestExecutor requestExecutor;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String login = (String) delegateExecution.getVariable("login");
        String password = (String) delegateExecution.getVariable("password");
        User userSoap = new User(1L,login,login,password);
        UserResponse response = requestExecutor.getUser(userSoap);
        List<User> users = response.getUsers();
        delegateExecution.setVariable("validUser", users.isEmpty());
    }
}
