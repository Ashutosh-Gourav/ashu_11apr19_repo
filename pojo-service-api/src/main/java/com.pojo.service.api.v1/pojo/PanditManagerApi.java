package com.pojo.service.api.v1.pojo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@Path("/pandit")
public interface PanditManagerApi {

    @GET
    @Produces("application/json")
    @Path("/details")
    com.pojo.service.api.v1.pojo.PanditdetailsResponse getPanditDetails();

    @POST
    @Produces("application/json")
    @Path("/registration")
    com.pojo.service.api.v1.pojo.UserOtp register(com.pojo.service.api.v1.pojo.PriestRegistrationRequest priestRegistrationRequest);
}