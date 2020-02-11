package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.NewBookingResponseObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class NewUserBookingRowMapper implements RowMapper {
    @Override
    public NewBookingResponseObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        NewBookingResponseObject newBookingResponseObject = new NewBookingResponseObject();
        newBookingResponseObject.setPrepBy(rs.getString("prepBy"));
        newBookingResponseObject.setPoojaAddress(rs.getString("poojaAddress"));
        newBookingResponseObject.setPoojaAddressLongitude(rs.getFloat("poojaAddressLongitude"));
        newBookingResponseObject.setPoojaAddressLatitude(rs.getFloat("poojaAddressLatitude"));
        newBookingResponseObject.setPoojaid(rs.getInt("poojaId"));
        newBookingResponseObject.setPoojalanguage(rs.getString("poojalanguage"));
        newBookingResponseObject.setPoojaStartTime(rs.getTimestamp("poojaStartTime"));
        newBookingResponseObject.setStatus(rs.getString("status"));
        newBookingResponseObject.setUserFullName(rs.getString("userFullName"));
        newBookingResponseObject.setUserMobileNumber(rs.getString("mobileNumber"));
        newBookingResponseObject.setPoojabookingrequestId(rs.getString("poojabookingrequestId"));

        return newBookingResponseObject;
    }
}
