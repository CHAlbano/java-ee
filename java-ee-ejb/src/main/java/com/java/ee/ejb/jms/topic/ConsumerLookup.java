package com.java.ee.ejb.jms.topic;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.NamingException;

public class ConsumerLookup {

	public static void main(String[] args) throws NamingException, JMSException {

		Context ctx = TopicUtilJMS.getContext();

		TopicConnectionFactory tConFactory = (TopicConnectionFactory) ctx.lookup(TopicUtilJMS.LOCAL_FACTORY);

		Topic messageTopic = (Topic) ctx.lookup(TopicUtilJMS.LOCAL_TOPIC);

		TopicConnection tCon = tConFactory.createTopicConnection();

		TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	
		TopicSubscriber subscriber = session.createSubscriber(messageTopic);

		tCon.start();

		TextMessage msg = (TextMessage) subscriber.receive();

		System.err.println("Received: " + msg.getText());

	}

}
