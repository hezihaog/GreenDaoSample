package com.hzh.green.dao.sample.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

/**
 * Package: com.hzh.green.dao.sample.entity
 * FileName: CertificateEntity
 * Date: on 2018/8/5  上午11:47
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
@Entity(nameInDb = "certificate_info")
public class CertificateInfoEntity {
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
     * 一对一关系，关联person_info表的主键
     */
    private String personInfoId;

    /**
     * 证件类型，暂时这里只有一个身份证类型，所以只是一个一对一的关系
     */
    @Property(nameInDb = "certificate_type")
    @NotNull
    private String certificateType;

    /**
     * 证件号
     */
    @Property(nameInDb = "certificate_no")
    @NotNull
    private String certificateNo;

    @Generated(hash = 1257837941)
    public CertificateInfoEntity(String id, @NotNull Date createTime,
            @NotNull Date updateTime, @NotNull Integer deleteFlag,
            @NotNull Integer version, String personInfoId,
            @NotNull String certificateType, @NotNull String certificateNo) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
        this.version = version;
        this.personInfoId = personInfoId;
        this.certificateType = certificateType;
        this.certificateNo = certificateNo;
    }

    @Generated(hash = 1400524197)
    public CertificateInfoEntity() {
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

    public String getCertificateType() {
        return this.certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return this.certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }
}