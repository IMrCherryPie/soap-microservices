package com.soapclient;

import com.soap.gen.User;
import com.soap.gen.UserRequest;
import com.soap.gen.UserResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class RequestExecutor extends WebServiceGatewaySupport {

    public UserResponse getUser(User user) {
        UserRequest request = new UserRequest();
        request.setUser(user);
        return (UserResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8091/ws", request);
    }
}
