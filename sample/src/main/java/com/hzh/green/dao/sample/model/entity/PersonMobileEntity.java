package com.hzh.green.dao.sample.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * Package: com.hzh.green.dao.sample.entity
 * FileName: PersonMobileEntity
 * Date: on 2018/8/5  上午11:26
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
@Entity(nameInDb = "person_mobile")
public class PersonMobileEntity {
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

    /**
     * 外键关联person_info表，一个人有多个手机号，一对多，不能设置字段属性注解
     */
    private String personInfoId;

    @Property(nameInDb = "mobile_num")
    @NotNull
    private String mobileNum;

    @Generated(hash = 1194423063)
    public PersonMobileEntity(String id, @NotNull Date createTime,
            @NotNull Date updateTime, @NotNull Integer deleteFlag,
            @NotNull Integer version, String personInfoId,
            @NotNull String mobileNum) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
        this.version = version;
        this.personInfoId = personInfoId;
        this.mobileNum = mobileNum;
    }

    @Generated(hash = 1415690332)
    public PersonMobileEntity() {
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

    public String getPersonInfoId() {
        return this.personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getMobileNum() {
        return this.mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}