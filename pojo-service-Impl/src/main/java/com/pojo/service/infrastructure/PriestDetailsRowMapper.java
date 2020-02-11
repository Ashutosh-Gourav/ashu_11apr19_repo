package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.RegisteredPriestDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class PriestDetailsRowMapper implements RowMapper{


    @Override
    public RegisteredPriestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        RegisteredPriestDetails registeredPriestDetails= new RegisteredPriestDetails();
        registeredPriestDetails.setId(rs.getInt("id"));
        registeredPriestDetails.setName(rs.getString("name"));
        registeredPriestDetails.setPhoneNumber(rs.getString("phoneNumber"));
        registeredPriestDetails.setPriestPassword(rs.getString("priestPassword"));
        registeredPriestDetails.setRegisteredLatitude(rs.getFloat("registeredLatitude"));
        registeredPriestDetails.setRegisteredLongitude(rs.getFloat("registeredLongitude"));
        registeredPriestDetails.setLang(rs.getString("lang"));
        registeredPriestDetails.setDob(rs.getDate("dob"));
        registeredPriestDetails.setExperience(rs.getInt("experience"));
        registeredPriestDetails.setProofId(rs.getString("proofId"));
        registeredPriestDetails.setIdProofType(rs.getString("idProofType"));
        registeredPriestDetails.setIdImage(rs.getBlob("idImage"));
        registeredPriestDetails.setStatus(rs.getString("status"));
        registeredPriestDetails.setIdImage(rs.getBlob("priestImage"));
        registeredPriestDetails.setVerified(rs.getBoolean("isVerified"));
        registeredPriestDetails.setPriestEmail(rs.getString("priestEmail"));

        return registeredPriestDetails;
    }
}
