package org.js.test.server;

import org.jboss.errai.bus.server.annotations.Remote;

@Remote
public interface HelloService {
    String sayHello(String value);
}
