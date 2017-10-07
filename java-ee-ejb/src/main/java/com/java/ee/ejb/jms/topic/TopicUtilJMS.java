package com.java.ee.ejb.jms.topic;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicUtilJMS {
	
	public static final String WEBLOGIC_CLASS = "weblogic.jndi.WLInitialContextFactory";
	public static final String WEBLOGIC_URL = "t3://localhost:7001";
	 
	public static final String LOCAL_FACTORY = "jms/testConnectionFactoryLocal";
	public static final String LOCAL_TOPIC = "jms/testLocal";
	
	public static final String REMOTE_FACTORY = "jms/testConnectionFactoryRemote";
	public static final String REMOTE_TOPIC = "jms/testRemote";
	
	public static InitialContext getContext() throws NamingException {
		
		final Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, TopicUtilJMS.WEBLOGIC_CLASS);
		env.put(Context.PROVIDER_URL, TopicUtilJMS.WEBLOGIC_URL);
		
		return new InitialContext(env);
		
	}

}
