package com.pojo.service.api.v1.pojo;

import javax.ws.rs.*;

/**
 * Created by gourava on 1/20/17.
 */
@Path("/v1/notification")
public interface NotificationApi {

    @Consumes("application/json")
    @Path("/fcm/register")
    @PUT
    void saveFcmAndDeviceInfo(com.pojo.service.api.v1.pojo.FcmRegistrationRequest fcmRegistrationRequest);
}
