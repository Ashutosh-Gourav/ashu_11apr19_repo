package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.*;
import com.pojo.service.infrastructure.sql.KeyHolderFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    @Resource
    private NamedParameterJdbcOperations namedParameterJdbcTemplate;
    @Resource
    private RowMapper<RegisteredUserDetails> userRowMapper;

    @Resource
    private RowMapper<RegisteredUserBookingDetails> registeredUserBookingDetailsRowMapper;
    @Resource
    private KeyHolderFactory keyHolderFactory;


    private static final String SELECT_USERDETAILS ="select * from g4o_userDetails where mobileNumber =:mobilenumber ";
    private static final String SELECT_USERDETAILS_AFTER_VERIFICATION ="select * from g4o_userDetails where mobileNumber =:mobileNumber and email =:email and status = :status";

    private static final String SELECT_ACTIVE_USERDETAILS="select * from g4o_userDetails where mobileNumber = :mobileNumber and status='active'";
    private static final String INSERT_USERDETAILS = "insert into g4o_userDetails(email,password,mobileNumber,userFullName,registeredAddress,status) values (:email,:password,:mobileNumber,:userFullName,registeredAddress,:status)";
    private static final String UPDATE_USERDETAILS="UPDATE g4o_userDetails SET email =:email ,password =:password ,mobileNumber =:mobileNumber,userFullName =:userFullName,registeredAddress=:registeredAddress where mobileNumber =:mobileNumber and status = :status";
    private static final String UPDATE_STATUS="UPDATE g4o_userDetails SET status=:status where mobileNumber =:mobileNumber and email = :email";
    private static final String UPDATE_PASSWORD="UPDATE g4o_userDetails SET password=:password where mobileNumber =:mobileNumber and email = :email and status = 'active'";
    private static final String UPDATE_USERDETAILS_SAME_EMAIL="UPDATE g4o_userDetails SET email =:email ,password =:password ,mobileNumber =:mobileNumber,userFullName =:userFullName,registeredAddress=:registeredAddress where mobileNumber =:mobileNumber and email= :email and status = :status";
    private static final String SELECT_USERNAME_FOR_BOOKING_REQUEST_ID="SELECT u.userFullName,b.offeredPrice,b.poojaAddress,b.poojaAddressLongitude ,b.poojaAddressLatitude,b.prepBy,b.poojalanguage,b.poojaStartTime,b.poojaId FROM g4o_userDetails u join g4odb.g4o_user_booking b on u.mobileNumber = b.userId and b.poojabookingrequestId= :poojabookingrequestId and u.status='active'";




    @Override
    public List<RegisteredUserDetails> getUserDetails(User user) {
        List<RegisteredUserDetails> registeredUserDetails;
        registeredUserDetails =namedParameterJdbcTemplate.query(SELECT_USERDETAILS, new MapSqlParameterSource("mobilenumber", user.getMobileNumber()), userRowMapper);
        return registeredUserDetails;
    }

    @Override
    public List<RegisteredUserDetails> getUserDetailsForStatusUpdate(User user,String status) {
        List<RegisteredUserDetails> registeredUserDetails;
        registeredUserDetails =namedParameterJdbcTemplate.query(SELECT_USERDETAILS_AFTER_VERIFICATION, insertStatussource(user.getMobileNumber(),user.getEmail(),status), userRowMapper);
        return registeredUserDetails;
    }

    private SqlParameterSource createVerifiedInsertSource(String email, String mobileNumber) {
        MapSqlParameterSource source= new MapSqlParameterSource();
        source.addValue("email",email);
        source.addValue("mobileNumber",mobileNumber);
        return source;
    }

    @Override
    public List<RegisteredUserDetails> getActiveUserDetails(User user) {
        List<RegisteredUserDetails> registeredUserDetails;
        registeredUserDetails =namedParameterJdbcTemplate.query(SELECT_ACTIVE_USERDETAILS, new MapSqlParameterSource("mobileNumber",user.getMobileNumber()), userRowMapper);

        return registeredUserDetails;
    }


    @Override
    public void saveUserDetails(User user,String status) {

        KeyHolder keyHolder = keyHolderFactory.create();
        try{
            namedParameterJdbcTemplate.update(INSERT_USERDETAILS,createInsertSource(user,status),keyHolder);
        }catch (Exception e){
            throw  new PojoException("DB insertion error",e.getCause());
        }

    }

    @Override
    public void updateUserDetails(User user) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_USERDETAILS,createupdateInsertSource(user));

        }catch (Exception e){
            throw new PojoException("Problem while updating db");
        }
    }

    @Override
    public void updateStatus(String mobileNumber, String email,String status) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_STATUS,insertStatussource(mobileNumber,email,status));

        }catch (Exception e){
            throw new PojoException("Problem while updating db");
        }
    }

    @Override
    public void updateUserPassword(User user) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_PASSWORD,updatePasswordSource(user));

        }catch (Exception e){
            throw new PojoException("Problem while updating db");
        }
    }

    @Override
    public void updateUserDetailsWithSameEmail(User user) {
        try{
            namedParameterJdbcTemplate.update(UPDATE_USERDETAILS_SAME_EMAIL,updateUserDetailsOnSameEmailAndStatusInactive(user));

        }catch (Exception e){
            throw new PojoException("Problem while updating db");
        }
    }

    @Override
    public List<RegisteredUserBookingDetails> getUserNameForBookingId(String userBookingRequestId) {
        ResultSet resultSet = null;
        List<RegisteredUserBookingDetails> userName = null;
        try{
             userName = namedParameterJdbcTemplate.query(SELECT_USERNAME_FOR_BOOKING_REQUEST_ID,new MapSqlParameterSource("poojabookingrequestId",userBookingRequestId), registeredUserBookingDetailsRowMapper);

        }catch (Exception e){
        throw new PojoException("Some error occured");
        }
        return userName;
    }

    private SqlParameterSource updatePasswordSource(User user){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("password",user.getPassword());
        source.addValue("mobileNumber",user.getMobileNumber());
        source.addValue("email",user.getEmail());
        return  source;
    }

    private SqlParameterSource insertStatussource(String mobileNumber,String email,String status) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("status",status);
        source.addValue("mobileNumber",mobileNumber);
        source.addValue("email",email);
        return source;

    }

    private SqlParameterSource updateUserDetailsOnSameEmailAndStatusInactive(User user) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("email", user.getEmail());
        source.addValue("password",user.getPassword());
        source.addValue("mobileNumber",user.getMobileNumber());
        source.addValue("userFullName",user.getName());
        source.addValue("status","inactive");
        source.addValue("registeredAddress",user.getRegisteredAddress());
//        source.addValue("deviceId",user.getDeviceId());
        return source;

    }

    private SqlParameterSource createInsertSource(User user,String status) {

        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("email", user.getEmail());
        source.addValue("password",user.getPassword());
        source.addValue("mobileNumber",user.getMobileNumber());
        source.addValue("userFullName",user.getName());
        source.addValue("status",status);
        source.addValue("registeredAddress",user.getRegisteredAddress());
        source.addValue("deviceId",user.getDeviceId());
        return source;
    }
    private SqlParameterSource createupdateInsertSource(User user) {

        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("email", user.getEmail());
        source.addValue("password",user.getPassword());
        source.addValue("mobileNumber",user.getMobileNumber());
        source.addValue("userFullName",user.getName());
        source.addValue("status","inactive");
        source.addValue("registeredAddress",user.getRegisteredAddress());
        return source;
    }
}
