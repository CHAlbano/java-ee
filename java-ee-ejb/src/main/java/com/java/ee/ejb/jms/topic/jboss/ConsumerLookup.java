package com.java.ee.ejb.jms.topic.jboss;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.java.ee.ejb.jms.topic.TopicUtilJMS;

public class ConsumerLookup {

	public static void main(String[] args) throws NamingException, JMSException {
		
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "remote://10.51.6.23:4447");
		env.put(Context.SECURITY_PRINCIPAL, "baby");
		env.put(Context.SECURITY_CREDENTIALS, "@admin123");
		Context ctx = new InitialContext(env);

		TopicConnectionFactory tConFactory = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");

		Topic messageTopic = (Topic) ctx.lookup("jms/topic/mesa");

		TopicConnection tCon = tConFactory.createTopicConnection();

		TopicSession session = tCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	
		TopicSubscriber subscriber = session.createSubscriber(messageTopic);

		tCon.start();

		TextMessage msg = (TextMessage) subscriber.receive();

		System.err.println("Received: " + msg.getText());

	}

}
