package com.pojo.service.api.v1.healthcheck;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/public/v1")
public interface HealthCheckApi {
    @GET
    @Path("/healthcheck")
    boolean healthCheck();
}
