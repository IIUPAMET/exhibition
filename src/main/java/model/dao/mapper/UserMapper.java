package model.dao.mapper;

import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {
    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setPass(null);
        user.setLogin(rs.getString("login"));
        user.setMail(rs.getString("mail"));
        user.setNameEN(rs.getString("first_name_en"));
        user.setNameUA(rs.getString("first_name_ua"));
        user.setRole(User.Role.valueOf(rs.getString("role")));
        return user;
    }

    @Override
    public User makeUnique(Map<Integer, User> cache, User teacher) {
        return null;
    }
}
