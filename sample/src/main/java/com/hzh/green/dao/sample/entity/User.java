package com.hzh.green.dao.sample.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Package: com.hzh.green.dao.sample.entity
 * FileName: User
 * Date: on 2017/12/28  下午4:36
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */

@Entity(
        //表名，默认为类名
        nameInDb = "MMC_USER",
        //是否需要greenDao创建表，默认为true
        createInDb = true,
        //是否生成所有参数构造器
        generateConstructors = true,
        //如果没有提供get、set方法，是否生成，默认为true
        generateGettersSetters = true
)
public class User {
    //id，并且设置主键
    @Id(autoincrement = true)
    private Long id;

    //用户id，是唯一的，设置为默认索引
    @Unique
    private String userId;

    //用户名，指定列名为USERNAME
    @Property(nameInDb = "USERNAME")
    private String userName;

    //年龄
    @Property(nameInDb = "AGE")
    private int age;

    //签名
    @Property(nameInDb = "SIGN")
    @NotNull
    private String sign;

@Generated(hash = 482553960)
public User(Long id, String userId, String userName, int age,
        @NotNull String sign) {
    this.id = id;
    this.userId = userId;
    this.userName = userName;
    this.age = age;
    this.sign = sign;
}

@Generated(hash = 586692638)
public User() {
}

public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public String getUserId() {
    return this.userId;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public String getUserName() {
    return this.userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public int getAge() {
    return this.age;
}

public void setAge(int age) {
    this.age = age;
}

public String getSign() {
    return this.sign;
}

public void setSign(String sign) {
    this.sign = sign;
}
}