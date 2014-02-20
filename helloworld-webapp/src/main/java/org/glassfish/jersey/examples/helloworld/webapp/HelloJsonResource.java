package org.glassfish.jersey.examples.helloworld.webapp;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.examples.helloworld.model.HelloInfo;

@Path("/hello")
public class HelloJsonResource {

    @GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON})
    public Response getDate() {
		
    	HelloInfo helloBean = new HelloInfo();

        return Response.ok(helloBean).build();
    }

}
