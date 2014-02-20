package org.glassfish.jersey.examples.helloworld.spring;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class SpringRequestResourceTest  extends JerseyTest{

    @Override
    protected Application configure() {
        return new MyApplication();
    }
    
	@Test
	public void testGetHello() {
        String s = target().path("/spring-hello").request().get(String.class);
        assertEquals("Hello Worlda!", s);
	}
	


}
