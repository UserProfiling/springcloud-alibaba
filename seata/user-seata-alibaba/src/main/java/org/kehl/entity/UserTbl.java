package org.kehl.entity;

import java.io.Serializable;

/**
 * (UserTbl)实体类
 *
 * @author kehl
 * @since 2022-05-23 14:53:07
 */
public class UserTbl implements Serializable {
    private static final long serialVersionUID = -72049928855718092L;

    private Integer id;

    private String userId;

    private String username;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
