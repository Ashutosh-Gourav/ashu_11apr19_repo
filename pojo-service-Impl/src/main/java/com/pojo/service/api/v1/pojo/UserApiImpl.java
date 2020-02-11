package com.pojo.service.api.v1.pojo;


import com.pojo.service.application.LoginApplication;
import com.pojo.service.domain.model.*;

import javax.annotation.Resource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

public class UserApiImpl implements com.pojo.service.api.v1.pojo.UserApi {
    @Resource
    private LoginApplication loginApplication;

    @Override
    public com.pojo.service.api.v1.pojo.UserOtp login(com.pojo.service.api.v1.pojo.LoginRequest loginRequest) {
        checkWebArgument(loginRequest != null, "Request cannot be null");
        checkWebArgument(loginRequest.getMobileNumber() != null, "mobile number cannot be null");
        checkWebArgument(loginRequest.getPassword() != null, "password cannot be null");
        checkWebArgument(!(loginRequest.getMobileNumber().trim().isEmpty()), "Mobile Number cannot be empty");
        checkWebArgument(!(loginRequest.getPassword().trim().isEmpty()), "Password cannot be empty");
        checkWebArgument(loginRequest.getDeviceId()!=null,"deviceId cannot be null");
        checkWebArgument(!(loginRequest.getDeviceId().trim().isEmpty()),"deviceId cannot be empty");

        User user = new User();
        user.setMobileNumber(loginRequest.getMobileNumber());
        user.setPassword(loginRequest.getPassword());
        user.setUser(loginRequest.getIsUser());
        user.setDeviceId(loginRequest.getDeviceId());
        user.setFcmRegistrationToken(loginRequest.getFcmRegistrationToken());


        com.pojo.service.api.v1.pojo.UserOtp userOtp = new com.pojo.service.api.v1.pojo.UserOtp();
        try {

            String otp = loginApplication.login(user);
            userOtp.setOtp(otp);

        } catch (PasswordMismatchException e) {
            throw new ClientErrorException(Response.status(Response.Status.UNAUTHORIZED).build(), e);

        } catch (UserNotFoundException e) {
            throw new ClientErrorException(Response.status(Response.Status.NOT_FOUND).build(), e);

        } catch (SmsSendingException e) {
            throw new ClientErrorException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);

        }
        return userOtp;
    }

    @Override
    public com.pojo.service.api.v1.pojo.UserOtp register(com.pojo.service.api.v1.pojo.NewUserRequest newUserRequest) {
        checkWebArgument(newUserRequest != null, "request cannot be null");
        checkWebArgument((newUserRequest.getMobileNumber() != null) && !(newUserRequest.getMobileNumber().trim().isEmpty()), "mobileNumber cannot be null or empty");
        checkWebArgument((newUserRequest.getEmail() != null) && !(newUserRequest.getEmail().trim().isEmpty()), "email cannot be null or empty");
        checkWebArgument((newUserRequest.getFullname() != null) && !(newUserRequest.getFullname().trim().isEmpty()), "FullName cannot be null or empty");
        checkWebArgument((newUserRequest.getPassword() != null) && (newUserRequest.getPassword().trim().length() < 15), "password lenghth should be greater than 8");
        checkWebArgument((newUserRequest.getDeviceId() != null) && !(newUserRequest.getDeviceId().trim().isEmpty()), "deviceId cannotBe empty");
        User user = new User();
        user.setName(newUserRequest.getFullname());
        user.setPassword(newUserRequest.getPassword());
        user.setMobileNumber(newUserRequest.getMobileNumber());
        user.setEmail(newUserRequest.getEmail());
        user.setRegisteredAddress(newUserRequest.getRegisteredAddress());
        user.setDeviceId(newUserRequest.getDeviceId());
        user.setFcmRegistrationToken(newUserRequest.getFcmRegistrationToken());

        String otp = null;
        com.pojo.service.api.v1.pojo.UserOtp userOtp = new com.pojo.service.api.v1.pojo.UserOtp();
        try {
            otp = loginApplication.saveUserDetails(user);
            userOtp.setOtp(otp);


        } catch (SmsSendingException e) {
            throw new ClientErrorException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);
        } catch (UserAlreadyExistException e) {
            throw new ClientErrorException(Response.status(Response.Status.FORBIDDEN).build(), e);
        }
        return userOtp;
    }

    @Override
    public void userConfirmation(com.pojo.service.api.v1.pojo.StatusConfirmationRequest statusConfirmationRequest) {
        checkWebArgument(statusConfirmationRequest != null, "request is null");
        checkWebArgument(statusConfirmationRequest.getEvent() != null, "Event cannot be null");
        checkWebArgument(!(statusConfirmationRequest.getEvent().trim().isEmpty()), "Event is empty");
        checkWebArgument(statusConfirmationRequest.getMobileNumber() != null, "mobileNumber cannot be null");
        checkWebArgument(!(statusConfirmationRequest.getMobileNumber().trim().isEmpty()), "mobileNumber is empty");
        checkWebArgument(statusConfirmationRequest.getEmail() != null, "email cannot be null");
        checkWebArgument(!(statusConfirmationRequest.getEmail().trim().isEmpty()), "email is empty");

        if (statusConfirmationRequest.getEvent().equalsIgnoreCase("registration")) {

            String mobileNumber = statusConfirmationRequest.getMobileNumber();
            String email = statusConfirmationRequest.getEmail();
            boolean isUser = statusConfirmationRequest.getIsUser();

            loginApplication.updateStatus(mobileNumber, email, isUser);


        }
    }

    @Override
    public com.pojo.service.api.v1.pojo.UserOtp userIdVerification(com.pojo.service.api.v1.pojo.UserMobileNumber mobileNumber) {
        checkWebArgument(mobileNumber != null, "mobileNumber cannot be null");
        checkWebArgument(!(mobileNumber.getMobileNumber().trim().isEmpty()), "mobileNumber is empty");

        com.pojo.service.api.v1.pojo.UserOtp userOtp = new com.pojo.service.api.v1.pojo.UserOtp();


        try {
            boolean isUser = mobileNumber.getIsUser();
            String resetOtp = loginApplication.resetUserPassword(mobileNumber.getEmail(),mobileNumber.getMobileNumber(), isUser);
            userOtp.setOtp(resetOtp);
        } catch (SmsSendingException e) {
            throw new ClientErrorException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build(), e);

        } catch (UserNotFoundException e) {
            throw new ClientErrorException(Response.status(Response.Status.NOT_FOUND).build(), e);

        }catch (EmailIdMisMatchException e){
            throw new ClientErrorException(Response.status(Response.Status.PRECONDITION_FAILED).build(), e);

        }

        return userOtp;
    }

    @Override
    public void userPasswordUpdate(com.pojo.service.api.v1.pojo.LoginRequest loginRequest) {
        checkWebArgument(loginRequest != null, "Request cannot be null");
        checkWebArgument(loginRequest.getMobileNumber() != null, "mobile number cannot be null");
        checkWebArgument(loginRequest.getPassword() != null, "password cannot be null");
        checkWebArgument(!(loginRequest.getMobileNumber().trim().isEmpty()), "Mobile Number cannot be empty");
        checkWebArgument(!(loginRequest.getPassword().trim().isEmpty()), "Password cannot be empty");
        User user = new User();
        user.setMobileNumber(loginRequest.getMobileNumber());
        user.setPassword(loginRequest.getPassword());
        user.setEmail(loginRequest.getEmail());
        user.setUser(loginRequest.getIsUser());
        try {
            loginApplication.updateUserPassword(user);

        } catch (UserNotFoundException e) {
            throw new ClientErrorException(Response.Status.NOT_FOUND, e);
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
