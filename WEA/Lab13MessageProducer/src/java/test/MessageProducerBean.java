/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author QQ
 */
//@Named(value = "messageProducerBean")
@ManagedBean
@RequestScoped
public class MessageProducerBean {

    @Resource(mappedName = "jms/myQueue")
    private Queue myQueue;

    @Inject
    @JMSConnectionFactory("jms/myQueueFactory")
    private JMSContext context;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageProducerBean() {
    }

//    private void sendJMSMessageToMyQueue(String messageData) {
//        context.createProducer().send(myQueue, messageData);
//    }
    public void send() throws NullPointerException, NamingException, JMSException {
        InitialContext initContext = new InitialContext();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ConnectionFactory factory = (ConnectionFactory) initContext.lookup("jms/myQueueFactory");
        Destination destination = (Destination) initContext.lookup("jms/myQueue");
        initContext.close();
        // Create JMS objects
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer sender = session.createProducer(myQueue);
        // Send messages
        TextMessage msg = session.createTextMessage(message);
        sender.send(msg);
        FacesMessage facesMessage = new FacesMessage("Message sent: " + message);
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        facesContext.addMessage(null, facesMessage);

    }

}
