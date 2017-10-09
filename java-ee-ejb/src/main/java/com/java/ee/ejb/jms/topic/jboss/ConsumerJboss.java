package com.java.ee.ejb.jms.topic.jboss;

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

import com.java.ee.ejb.jms.topic.TopicUtilJMS;
 
/*@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = TopicUtilJMS.LOCAL_TOPIC),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = TopicUtilJMS.LOCAL_FACTORY),
		@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "clientId", propertyValue = "mesaId") })
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.NOT_SUPPORTED)*/
public class ConsumerJboss implements MessageListener { 
 
	public void onMessage(Message message) {

		TextMessage textMessage = (TextMessage) message;

		try {
			System.out.println("CHUPAAAAAAAAAAAAAAAAa: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}