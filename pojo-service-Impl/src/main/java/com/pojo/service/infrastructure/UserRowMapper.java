package com.pojo.service.infrastructure;

import com.pojo.service.domain.model.RegisteredUserDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public RegisteredUserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        RegisteredUserDetails rowMapper = new RegisteredUserDetails();
        rowMapper.setId(rs.getInt("id"));
        rowMapper.setEmail(rs.getString("email"));
        rowMapper.setPassword(rs.getString("password"));
        rowMapper.setMobileNumber(rs.getString("mobileNumber"));
        rowMapper.setName(rs.getString("userFullName"));
        rowMapper.setStatus(rs.getString("status"));
        return rowMapper;
    }
}
