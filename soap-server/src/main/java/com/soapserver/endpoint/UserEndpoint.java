package com.soapserver.endpoint;

import com.soap.gen.UserRequest;
import com.soap.gen.UserResponse;
import com.soapserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private final String NAMESPACE_URI = "gen.soap.com";

    @Autowired
    UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "userRequest")
    @ResponsePayload
    public UserResponse getUsers(@RequestPayload UserRequest request) {
        UserResponse response = new UserResponse();
        String login = request.getUser().getName();
        if (login.equals("")){
            response.getUsers().addAll(userService.findUsers());
        }else {
            response.getUsers().addAll(userService.findUser(request.getUser()));
        }
        return response;
    }
}
