package com.pojo.service.api.v1.pojo;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@Path("/pooja")
@JsonIgnoreProperties(ignoreUnknown = true)
public interface PoojaDetailsApi {
    @GET
    @Path("/getdetails")
    @Produces("application/json")
    List<com.pojo.service.api.v1.pojo.PoojaDetailsResponse> getpoojaDetails();
}
