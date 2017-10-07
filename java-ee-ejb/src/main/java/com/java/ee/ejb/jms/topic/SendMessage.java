package com.java.ee.ejb.jms.topic;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.NamingException;

public class SendMessage {

	public static void main(String[] args) throws NamingException, JMSException {

		final String message = "Hello";

		Context ctx = TopicUtilJMS.getContext();

		TopicConnectionFactory tConFactory = (TopicConnectionFactory) ctx.lookup(TopicUtilJMS.REMOTE_FACTORY);

		Topic messageTopic = (Topic) ctx.lookup(TopicUtilJMS.REMOTE_TOPIC);

		TopicConnection tCon = tConFactory.createTopicConnection();

		TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

		TopicPublisher publisher = session.createPublisher(messageTopic);

		TextMessage msg = session.createTextMessage();
		
		System.out.println("Message to send: " + message);
		msg.setText(message);
		
		publisher.publish(msg);
		System.out.println("Message sended");

	}

}
