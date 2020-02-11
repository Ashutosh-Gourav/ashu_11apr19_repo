package com.pojo.service.api.v1.pojo;


import com.pojo.service.application.NotificationApplication;
import com.pojo.service.domain.model.FcmRegistrationInfo;
import com.pojo.service.domain.model.NotificationRepository;
import com.pojo.service.domain.model.PojoException;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by gourava on 1/20/17.
 */
public class NotificationApiImpl implements com.pojo.service.api.v1.pojo.NotificationApi {

    @Resource
    private NotificationApplication notificationApplication;

    @Override
    public void saveFcmAndDeviceInfo(com.pojo.service.api.v1.pojo.FcmRegistrationRequest fcmRegistrationRequest){

        checkWebArgument(fcmRegistrationRequest != null, "fcm request can not be null");
        checkWebArgument(fcmRegistrationRequest.getFcmRegistrationToken() != null, "fcm token cannot be null");
        checkWebArgument(!(fcmRegistrationRequest.getFcmRegistrationToken().trim().isEmpty()), "fcm token cannot be empty");

        checkWebArgument(fcmRegistrationRequest.getDeviceId() != null, "token cannot be null");
        checkWebArgument(!(fcmRegistrationRequest.getDeviceId().trim().isEmpty()), "token cannot be empty");
        FcmRegistrationInfo fcmRegistrationInfo = new FcmRegistrationInfo();
        fcmRegistrationInfo.setFcmRegistrationToken(fcmRegistrationRequest.getFcmRegistrationToken().trim());
        fcmRegistrationInfo.setDeviceId(fcmRegistrationRequest.getDeviceId().trim());
        try {
            notificationApplication.saveDeviceFcmInfo(fcmRegistrationInfo);
        }catch (PojoException ex){
        throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    public static void checkWebArgument(boolean assertion, String message) {
        if (!assertion) {
            try {
                throw new BadRequestException();
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
