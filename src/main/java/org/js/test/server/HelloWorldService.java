/*
 * Copyright 2009 JBoss, a divison Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.js.test.server;

import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.MessageCallback;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.common.client.protocols.MessageParts;

@Service
public class HelloWorldService implements MessageCallback {
  public void callback(Message message) {
    System.out.println("Received: " + message.get(String.class, MessageParts.Value));

    /**
     * Create a conversation with the sending client.
     */
    MessageBuilder.createConversation(message)
            /* to the 'WindowAlertTopic' */
            .toSubject("WindowAlertTopic")
                    /* with a message using the default message part */
            .with(MessageParts.Value, "Hello, World from Server!")
                    /* and an arbitrary part for good measure */
            .with("systemTime", System.currentTimeMillis())
                    /* finish constructing the message and reply to sender */
            .done().reply();
  }
}
