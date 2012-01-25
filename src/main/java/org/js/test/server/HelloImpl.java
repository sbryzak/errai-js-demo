package org.js.test.server;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.errai.bus.server.annotations.Service;
import org.js.test.server.HelloService;

@ApplicationScoped
@Service
public class HelloImpl implements HelloService {

    @Override
    public String sayHello(String value) {        
        return "Hello, " + value;
    }

}
