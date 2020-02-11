package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.RegisteredUserBookingDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by gourava on 1/29/17.
 */
public class RegisteredUserBookingDetailsRowMapper implements RowMapper {
    @Override
    public RegisteredUserBookingDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        RegisteredUserBookingDetails registeredUserBookingDetails = new RegisteredUserBookingDetails();
        registeredUserBookingDetails.setUserName(resultSet.getString("userFullName"));
        registeredUserBookingDetails.setLang(resultSet.getString("poojalanguage"));
        registeredUserBookingDetails.setPoojaId(resultSet.getInt("poojaId"));
        registeredUserBookingDetails.setPoojaLatitude(resultSet.getFloat("poojaAddressLatitude"));
        registeredUserBookingDetails.setPoojaLatitude(resultSet.getFloat("poojaAddressLongitude"));
        registeredUserBookingDetails.setPoojaStartTime(resultSet.getTimestamp("poojaStartTime"));
        registeredUserBookingDetails.setPrepBy(resultSet.getString("prepBy"));
        registeredUserBookingDetails.setOfferedPrice(resultSet.getInt("offeredPrice"));
        registeredUserBookingDetails.setPoojaAddress(resultSet.getString("poojaAddress"));

        return registeredUserBookingDetails;
    }
}
