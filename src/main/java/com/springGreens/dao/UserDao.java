package com.springGreens.dao;

import com.springGreens.domain.User;
import com.springGreens.util.connection.ConnectionMaker;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");

            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());

            ps.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if(c != null) {
                try {
                    c.close();
                }catch (SQLException e) {

                }
            }
        }
    }

    public User get(String id) throws SQLException, ClassNotFoundException {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT * FROM users WHERE id  = ?");
            ps.setString(1, id);

            rs = ps.executeQuery();

            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            if (user == null) throw new EmptyResultDataAccessException(1);

            return user;

        }catch (SQLException e) {
            throw e;
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e){

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    public void deleteAll() throws SQLException, ClassNotFoundException {

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("DELETE FROM users");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public int getCount() throws SQLException, ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT  count(*) FROM users");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);

        }catch (SQLException e) {
            throw e;
        }finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e){

                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
