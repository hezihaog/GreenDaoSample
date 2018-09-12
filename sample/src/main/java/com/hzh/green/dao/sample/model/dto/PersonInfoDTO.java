package com.hzh.green.dao.sample.model.dto;

import java.io.Serializable;

/**
 * Package: com.github.wally.wcdbsample.model.dto
 * FileName: PersonDTO
 * Date: on 2018/8/4  下午12:51
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonInfoDTO implements Serializable {
    /**
     * 住户信息Id，增加时不需要传，更新时需要
     */
    private String personInfoId;

    /**
     * 住户名称
     */
    private String personName;

    /**
     * 性别代号
     */
    private String sex;

    /**
     * 住户年龄
     */
    private Integer age;

    /**
     * 证件类型
     */
    private String certificateType;

    /**
     * 证件号
     */
    private String certificateNo;

    /**
     * 手机号
     */
    private String[] mobiles;

    public String getPersonInfoId() {
        return personInfoId;
    }

    public void setPersonInfoId(String personInfoId) {
        this.personInfoId = personInfoId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String[] getMobiles() {
        return mobiles;
    }

    public void setMobiles(String[] mobiles) {
        this.mobiles = mobiles;
    }
}