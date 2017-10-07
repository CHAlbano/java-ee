package com.java.ee.ejb.jms.topic;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "topicJms", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = TopicUtilJMS.LOCAL_FACTORY),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = TopicUtilJMS.LOCAL_TOPIC),
		@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable") })
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class Consumer implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage textMessage = (TextMessage) message;
		
		try {
			System.out.println("Message received: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
