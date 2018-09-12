package com.hzh.green.dao.sample.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * Package: com.hzh.green.dao.sample.entity
 * FileName: Person
 * Date: on 2018/8/5  上午11:17
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
@Entity(nameInDb = "person_info")
public class PersonInfoEntity {
    @Id
    private String id;

    @Property(nameInDb = "create_time")
    @NotNull
    private Date createTime = new Date();

    @Property(nameInDb = "update_time")
    @NotNull
    private Date updateTime = new Date();

    /**
     * 删除标识，0：未删除，1：删除
     */
    @Property(nameInDb = "delete_flag")
    @NotNull
    private Integer deleteFlag = 0;

    /**
     * 版本号，默认1
     */
    @Property(nameInDb = "version")
    @NotNull
    private Integer version = 1;

    //-------------------- 自定义属性 --------------------

    @Property(nameInDb = "person_name")
    @NotNull
    private String personName;

    @Property(nameInDb = "sex")
    @NotNull
    private String sex;

    @Property(nameInDb = "age")
    @NotNull
    private Integer age;

    @Generated(hash = 1430461071)
    public PersonInfoEntity(String id, @NotNull Date createTime,
            @NotNull Date updateTime, @NotNull Integer deleteFlag,
            @NotNull Integer version, @NotNull String personName,
            @NotNull String sex, @NotNull Integer age) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
        this.version = version;
        this.personName = personName;
        this.sex = sex;
        this.age = age;
    }

    @Generated(hash = 958033728)
    public PersonInfoEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}