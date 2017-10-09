package com.java.ee.ejb.jms.topic.jboss;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.naming.Context;
import javax.naming.InitialContext;

public class SendMessage {
	
	public static void main(String... args) {
        try {
            Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, "remote://10.51.6.23:4447");
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            properties.put(Context.SECURITY_PRINCIPAL, "baby");
            properties.put(Context.SECURITY_CREDENTIALS, "@admin123");
            Context context = new InitialContext(properties);
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
            Destination destination = (Destination) context.lookup("jms/topic/mesa");
            context.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
