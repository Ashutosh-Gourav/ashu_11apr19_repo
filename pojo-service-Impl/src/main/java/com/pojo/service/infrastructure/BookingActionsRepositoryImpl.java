package com.pojo.service.infrastructure;

import com.pojo.service.domain.constants.StatusType;
import com.pojo.service.domain.model.*;
import com.pojo.service.infrastructure.sql.KeyHolderFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class BookingActionsRepositoryImpl implements BookingActionsRepository {

    @Resource
    private NamedParameterJdbcOperations namedParameterJdbcTemplate;

    @Resource
    private RowMapper<BookingDetails> bookingDetailsRowMapper;

    @Resource
    private KeyHolderFactory keyHolderFactory;

    @Resource
    private RowMapper<String> priestImageRowMapper;

    @Resource
    private  RowMapper<UserBookingHistoryObject> userBookingHistoryRowMapper;

    @Resource
    private RowMapper<NewBookingResponseObject> newUserBookingRowMapper;


    private static final String SELECT_BOOKING_DETAILS ="select * from g4o_user_booking where userId =:userId and poojaId = :poojaId ";
    private static final String INSERT_BOOKING_DETAILS="insert into g4o_user_booking (poojabookingrequestId,userId,poojaAddress,poojaId,BookingRequestTime,poojaStartTime,poojalanguage,prepBy,poojaAddressLongitude,poojaAddressLatitude,status,offeredPrice) values(:poojabookingrequestId," +
            ":userId,:poojaAddress,:poojaId,:BookingRequestTime,:poojaStartTime,:poojalanguage,:prepBy,:poojaAddressLongitude,:poojaAddressLatitude,:status,:offeredPrice)";
    private static final  String SELECT_PRIEST_IMAGE="SELECT panditImage FROM g4odb.g4o_priest p join g4o_user_booking u where u.poojabookingrequestId = :poojabookingrequestId and p.id = u.assignedPriestId";
    private static final String SELECT_USER_BOOKING_HISTORY="SELECT * FROM g4odb.g4o_user_booking WHERE userId= :userId ORDER BY BookingRequestTime DESC ";
    private static final String SELECT_BOOKING_DETAILS_FOR_PRIEST="SELECT  u.userFullName ,u.mobileNumber,p.poojaAddress,p.poojaid,p.poojaStartTime,p.poojabookingrequestId,p.poojalanguage,p.prepBy,p.poojaAddressLongitude,p.poojaAddressLatitude,p.status from g4o_userDetails u JOIN g4o_user_booking p on u.mobileNumber=p.userId where p.status= :status and u.status='active'";
    private static final String UPDATE_BOOKING_STATUS = "UPDATE g4o_user_booking SET  status = :status where poojabookingrequestId = :poojabookingrequestId and status = 'pending'";
    private static final String UPDATE_BOOKING_REQUEST_WITH_PRIEST ="UPDATE g4o_user_booking SET assignedPriestId = :assignedPriestId,assignedPriestName =:assignedPriestName,assignedPriestPhNumber = :assignedPriestPhNumber and status = 'accepted' where poojabookingrequestId = :poojabookingrequestId";

    @Override
    public List<BookingDetails> getBookingDetails(String userId, int pooja) {
        List<BookingDetails> bookingDetails = namedParameterJdbcTemplate.query(SELECT_BOOKING_DETAILS, createInsertSource(userId,pooja), bookingDetailsRowMapper);
        return bookingDetails;
    }

    @Override
    public void saveUserBookingDetails(BookingDetails bookingDetails) {
        KeyHolder keyHolder = keyHolderFactory.create();
        namedParameterJdbcTemplate.update(INSERT_BOOKING_DETAILS,createSource(bookingDetails),keyHolder );

    }

    @Override
    public String getUserBookingPanditImage(String userBookingRequestId) {

         List<String> panditImageList = namedParameterJdbcTemplate.query(SELECT_PRIEST_IMAGE, new MapSqlParameterSource("poojabookingrequestId", userBookingRequestId), priestImageRowMapper);
        if(!panditImageList.isEmpty()){
            return panditImageList.get(0);

        }
        throw new UserBookingIdNotFoundException("the requested bookingId does not exist in our db");
    }

    @Override
    public List<UserBookingHistoryObject> getUserBookingHistory(String userId) {
        List<UserBookingHistoryObject> userBookingHistoryObjectList= namedParameterJdbcTemplate.query(SELECT_USER_BOOKING_HISTORY,new MapSqlParameterSource("userId",userId),userBookingHistoryRowMapper);
        return userBookingHistoryObjectList;
    }

    @Override
    public List<NewBookingResponseObject> getNewUserBookings() {

        List<NewBookingResponseObject> newBookingResponseObjectList=namedParameterJdbcTemplate.query(SELECT_BOOKING_DETAILS_FOR_PRIEST,new MapSqlParameterSource("status","pending"),newUserBookingRowMapper);
        return newBookingResponseObjectList;
    }

    @Override
    public void updateBookingStatusToExpired(NewBookingResponseObject newBookingResponseObject) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_BOOKING_STATUS,createUpdateStatusSource(newBookingResponseObject));
        }catch (Exception e){
            throw new PojoException("some db error occured");
        }

    }

    @Override
    public void updateBookingDetailsWithPriestInfo(String userBookingRequestId, String priestMobile, String priestName, int id) {
        try {
            namedParameterJdbcTemplate.update(UPDATE_BOOKING_REQUEST_WITH_PRIEST,createBookingUpdateWithPriestDetails(userBookingRequestId,priestMobile,priestName,id));
        }catch (Exception e){
            throw new PojoException("Some Db Error occured");
        }
    }

    private SqlParameterSource createBookingUpdateWithPriestDetails(String userBookingRequestId, String priestMobile, String priestName, int id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("assignedPriestId",id);
        source.addValue("assignedPriestName",priestName);
        source.addValue("poojabookingrequestId",userBookingRequestId);
        source.addValue("assignedPriestPhNumber",priestMobile);
        return source;
    }

    private SqlParameterSource createUpdateStatusSource(NewBookingResponseObject newBookingResponseObject) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("poojabookingrequestId",newBookingResponseObject.getPoojabookingrequestId());
        source.addValue("status", StatusType.EXPIRED.get());

        return source;
    }

    private SqlParameterSource createSource(BookingDetails bookingDetails){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("poojabookingrequestId",bookingDetails.getPoojaBookingRequestId());
        source.addValue("userId",bookingDetails.getUserId());
        source.addValue("poojaAddress",bookingDetails.getPoojaAddress());
        source.addValue("poojaId",bookingDetails.getPoojaId());
        source.addValue("BookingRequestTime",bookingDetails.getBookingRequestTime());
        source.addValue("poojaStartTime",bookingDetails.getPoojaStartTime());
        source.addValue("poojalanguage",bookingDetails.getPoojaLanguage());
        source.addValue("prepBy",bookingDetails.getPrepBy());
        source.addValue("poojaAddressLongitude",bookingDetails.getPoojaAddressLongitude());
        source.addValue("poojaAddressLatitude",bookingDetails.getPoojaAddressLatitude());
        source.addValue("status",bookingDetails.getPoojaBookingStatus());
        source.addValue("offeredPrice",bookingDetails.getOfferedPrice());
        return source;

    }

    private SqlParameterSource createInsertSource(String userId , int pooja) {

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("userId",userId);
        source.addValue("poojaId",pooja);
        return source;
    }
}
