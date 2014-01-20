package org.glassfish.jersey.examples.helloworld.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;


@Path("/old/helloworld")
public class HelloWorldResource2 {

    @Context
    ResourceContext ctx;
    
    
    @GET
    @Produces("text/html")
    public String getHello() {
    	HelloWorldResource hr = ctx.getResource(HelloWorldResource.class);
        return hr.getHello() + " Hello World, too!";
    }
}
