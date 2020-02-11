
package com.pojo.service.api.v1.pojo;

import javax.ws.rs.*;

@Path("/v1/user")
public interface UserApi {

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/login")
    com.pojo.service.api.v1.pojo.UserOtp login(com.pojo.service.api.v1.pojo.LoginRequest loginRequest);

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/register")
    com.pojo.service.api.v1.pojo.UserOtp register(com.pojo.service.api.v1.pojo.NewUserRequest newUserRequest);

    @POST
    @Consumes("application/json")
    @Path("/confirm/otp")
    void userConfirmation(com.pojo.service.api.v1.pojo.StatusConfirmationRequest statusConfirmationRequest);

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/number/verification")
    com.pojo.service.api.v1.pojo.UserOtp userIdVerification(com.pojo.service.api.v1.pojo.UserMobileNumber mobileNumber);

    @PUT
    @Consumes("application/json")
    @Path("/password/reset")
    void userPasswordUpdate(com.pojo.service.api.v1.pojo.LoginRequest loginRequest);
}
