package com.hzh.green.dao.sample.db.biz.impl;

import com.hzh.green.dao.sample.db.biz.ICertificateInfoBiz;
import com.hzh.green.dao.sample.db.dao.ICertificateInfoDao;
import com.hzh.green.dao.sample.db.dao.impl.CertificateInfoDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;

/**
 * Package: com.hzh.green.dao.sample.db.biz.impl
 * FileName: CertificateInfoBiz
 * Date: on 2018/8/5  下午2:57
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class CertificateInfoBiz implements ICertificateInfoBiz {
    private final ICertificateInfoDao mDao;

    public CertificateInfoBiz() {
        mDao = new CertificateInfoDao();
    }

    @Override
    public boolean addCertificateInfo(PersonInfoDTO dto) {
        return mDao.addCertificateInfo(dto);
    }
}