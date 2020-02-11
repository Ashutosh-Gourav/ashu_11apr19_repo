package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.BookingDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by virmanv on 26/09/2016 October.
 *
 */
public class BookingDetailsRowMapper implements RowMapper {
    @Override
    public BookingDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        BookingDetails bookingDetails = new BookingDetails();
        bookingDetails.setBookingRequestTime(rs.getTimestamp("BookingRequestTime"));
        bookingDetails.setPoojaAddress(rs.getString("poojaAddress"));
        bookingDetails.setPoojaAddressLatitude(rs.getFloat("poojaAddressLatitude"));
        bookingDetails.setPoojaAddressLongitude(rs.getFloat("poojaAddressLongitude"));
        bookingDetails.setPoojaBookingStatus(rs.getString("status"));
        bookingDetails.setPoojaBookingRequestId(rs.getString("poojabookingrequestId"));
        bookingDetails.setPoojaId(rs.getInt("poojaId"));
        bookingDetails.setUserId(rs.getString("userId"));
        bookingDetails.setPoojaStartTime(rs.getTimestamp("poojaStartTime"));
        bookingDetails.setPoojaLanguage(rs.getString("poojalanguage"));
        bookingDetails.setId(rs.getInt("id"));
        bookingDetails.setPrepBy(rs.getString("prepBy"));
        bookingDetails.setAssignedPriestId(rs.getInt("assignedPriestId"));
        bookingDetails.setBookingStatus(rs.getString("status"));
        bookingDetails.setOfferedPrice(rs.getInt("offeredPrice"));
        return bookingDetails;
    }
}