/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author QQ
 */
@JMSDestinationDefinition(name = "jms/myQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "myQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue")
})
public class MesReceiver implements MessageListener {

    public MesReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;
            try {
                System.out.println("Consumed message: " + msg.getText());
            } catch (Exception e) {
            }
        } else {
            System.out.println("Message of wrong type: " + message.getClass().getName());
        }

    }

}
