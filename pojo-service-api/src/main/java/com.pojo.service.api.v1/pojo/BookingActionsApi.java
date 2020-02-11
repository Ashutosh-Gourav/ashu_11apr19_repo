package com.pojo.service.api.v1.pojo;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
@Path("/booking")
public interface BookingActionsApi {

    @Consumes("application/json")
    @Path("/user")
    @PUT
    void userBookingRequest(com.pojo.service.api.v1.pojo.UserBookingRequest userBookingRequest);

    @Path("/priest/image")
    @POST
    @Produces("application/json")
    com.pojo.service.api.v1.pojo.PriestImageResponseObject getUserBookingPanditImage( com.pojo.service.api.v1.pojo.UserBookingRequestId userBookingRequestId);

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/user/history")
    List<com.pojo.service.api.v1.pojo.BookingDetailsResponse> getUserBookingHistory(com.pojo.service.api.v1.pojo.UserId userId);


    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/new/request")
    List<com.pojo.service.api.v1.pojo.NewBookingResponse> getNewBookingDetails(com.pojo.service.api.v1.pojo.NewBookingRequest newBookingRequest);

    @PUT
    @Consumes("application/json")
    @Path("/accept")
    com.pojo.service.api.v1.pojo.BookingAcceptanceResponse userBookingAcceptance(com.pojo.service.api.v1.pojo.UserBookingRequestId bookingRequestId);



}
