package com.pojo.service.api.v1.pojo;

import com.pojo.service.application.PriestManagerApplication;
import com.pojo.service.domain.model.PojoException;
import com.pojo.service.domain.model.SmsSendingException;
import com.pojo.service.domain.model.User;
import com.pojo.service.domain.model.UserAlreadyExistException;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PanditManagerApiImpl implements com.pojo.service.api.v1.pojo.PanditManagerApi {

    @Resource
    private PriestManagerApplication priestManagerApplication;

    @Override
    public com.pojo.service.api.v1.pojo.PanditdetailsResponse getPanditDetails() {
        return null;
    }

    @Override
    public com.pojo.service.api.v1.pojo.UserOtp register(com.pojo.service.api.v1.pojo.PriestRegistrationRequest priestRegistrationRequest) {
        checkWebArgument(priestRegistrationRequest!=null,"request cannot be null");
        checkWebArgument(priestRegistrationRequest.getDeviceId()!=null,"DeviceId cannot be null");
        checkWebArgument(priestRegistrationRequest.getPhNumber()!=null,"PhoneNumber cannot be null");
        checkWebArgument(!(priestRegistrationRequest.getPhNumber().trim().isEmpty()),"PhoneNumber cannot be empty");
        checkWebArgument(!(priestRegistrationRequest.getDeviceId().trim().isEmpty()),"DeviceId cannot be null");
        checkWebArgument(priestRegistrationRequest.getRegisteredLatitude() > 7 && priestRegistrationRequest.getRegisteredLatitude() < 33, "Latitude should vary from 8-32");
        checkWebArgument((priestRegistrationRequest.getRegisteredLongitude() > 69) && (priestRegistrationRequest.getRegisteredLongitude() < 93), "longitude should vary from 70-92 ");


        com.pojo.service.api.v1.pojo.UserOtp userOtp = new com.pojo.service.api.v1.pojo.UserOtp();

        try{
            User user = new User();
            user.setDeviceId(priestRegistrationRequest.getDeviceId());
            user.setMobileNumber(priestRegistrationRequest.getPhNumber());
            user.setRegisteredAddress(priestRegistrationRequest.getAddress());
            user.setEmail(priestRegistrationRequest.getEmail());

            user.setName(priestRegistrationRequest.getName());
            user.setRegisteredLatitude(priestRegistrationRequest.getRegisteredLatitude());
            user.setRegisteredLongitude(priestRegistrationRequest.getRegisteredLongitude());
            user.setFcmRegistrationToken(priestRegistrationRequest.getFcmRegistrationToken());

            String otp = priestManagerApplication.saveUserDetails(user);
            userOtp.setOtp(otp);
            return  userOtp;


        }catch (SmsSendingException e){
            throw new WebApplicationException(Response.Status.PARTIAL_CONTENT);

        }catch (UserAlreadyExistException e){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }catch (PojoException e){
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
