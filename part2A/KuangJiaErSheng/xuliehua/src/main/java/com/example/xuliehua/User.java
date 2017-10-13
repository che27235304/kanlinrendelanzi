package com.example.xuliehua;

import java.io.Serializable;

/**
 * Created by KING on 2017/9/21 20:38
 * 邮箱:992767879@qq.com
 */

public class User implements Serializable {
    private static final long serilVersionUID=51960712364584654L;
    public int userId;
    public String userName;
    public boolean  isMale;

    public User(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }
}
