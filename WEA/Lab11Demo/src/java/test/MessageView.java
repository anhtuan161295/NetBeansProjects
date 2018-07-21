/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author QQ
 */
//@Named(value = "messageView")
@ManagedBean
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    private Message message;

    public MessageView() {
        this.message = new Message();
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }

    public String postMessage() {
        this.messageFacade.create(message);
        return "response";
    }

}
