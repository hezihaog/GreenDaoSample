package com.hzh.green.dao.sample.enums;

/**
 * Package: com.hzh.green.dao.sample.enums
 * FileName: CertificateTypeEnums
 * Date: on 2018/8/10  下午11:03
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public enum CertificateTypeEnums implements IEnums {
    IDENTITY("1", "身份证");

    private String mCode;
    private String mDesc;

    CertificateTypeEnums(String code, String desc) {
        mCode = code;
        mDesc = desc;
    }

    @Override
    public String getCode() {
        return mCode;
    }

    @Override
    public String getDesc() {
        return mDesc;
    }
}
