package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.UserBookingHistoryObject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class UserBookingHistoryRowMapper implements RowMapper {
    @Override
    public UserBookingHistoryObject mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserBookingHistoryObject userBookingHistoryObject = new UserBookingHistoryObject();
        userBookingHistoryObject.setBookingRequestTime(rs.getTimestamp("BookingRequestTime"));
        userBookingHistoryObject.setPoojaAddress(rs.getString("poojaAddress"));
        userBookingHistoryObject.setPoojaAddressLatitude(rs.getFloat("poojaAddressLatitude"));
        userBookingHistoryObject.setPoojaAddressLongitude(rs.getFloat("poojaAddressLongitude"));
        userBookingHistoryObject.setPoojaBookingStatus(rs.getString("status"));
        userBookingHistoryObject.setPoojaBookingRequestId(rs.getString("poojabookingrequestId"));
        userBookingHistoryObject.setPoojaId(rs.getInt("poojaId"));
        userBookingHistoryObject.setUserId(rs.getString("userId"));
        userBookingHistoryObject.setPoojaStartTime(rs.getTimestamp("poojaStartTime"));
        userBookingHistoryObject.setPoojaLanguage(rs.getString("poojalanguage"));
        userBookingHistoryObject.setId(rs.getInt("id"));
        userBookingHistoryObject.setPrepBy(rs.getString("prepBy"));
        userBookingHistoryObject.setAssignedPanditId(String.valueOf(rs.getInt("assignedPriestId")));
        userBookingHistoryObject.setPanditName(rs.getString("assignedPriestName"));
        userBookingHistoryObject.setPanditPhone(rs.getString("assignedPriestPhNumber"));
        userBookingHistoryObject.setOfferedPrice(rs.getInt("offeredPrice"));
        return userBookingHistoryObject;
    }
}
