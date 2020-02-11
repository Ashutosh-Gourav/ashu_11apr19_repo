package com.pojo.service.infrastructure;


import com.pojo.service.domain.model.FcmRegistrationInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gourava on 1/20/17.
 */
public class NotificationRowMapper implements RowMapper {
    @Override
    public FcmRegistrationInfo mapRow(ResultSet resultSet, int i) throws SQLException {

        FcmRegistrationInfo fcmRegistrationInfo = new FcmRegistrationInfo();
        fcmRegistrationInfo.setId(resultSet.getInt("id"));
        fcmRegistrationInfo.setFcmRegistrationToken(resultSet.getString("fcmRegistrationToken"));
        fcmRegistrationInfo.setDeviceId(resultSet.getString("deviceId"));
        fcmRegistrationInfo.setPersonId(resultSet.getInt("personId"));
        fcmRegistrationInfo.setUser(resultSet.getBoolean("isUser"));
        return fcmRegistrationInfo;
    }
}
