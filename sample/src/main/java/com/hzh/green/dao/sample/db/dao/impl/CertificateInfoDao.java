package com.hzh.green.dao.sample.db.dao.impl;
import com.hzh.green.dao.sample.db.dao.ICertificateInfoDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.entity.CertificateInfoEntity;
import com.hzh.green.dao.sample.model.entity.CertificateInfoEntityDao;
import com.hzh.green.dao.sample.util.GreenDaoManager;
import com.hzh.green.dao.sample.util.UUIDUtil;

/**
 * Package: com.hzh.green.dao.sample.db.dao.impl
 * FileName: CertificateInfoDao
 * Date: on 2018/8/5  下午3:05
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class CertificateInfoDao implements ICertificateInfoDao {
    private final CertificateInfoEntityDao mEntityDao;

    public CertificateInfoDao() {
        mEntityDao = GreenDaoManager.getInstance().getDaoSession().getCertificateInfoEntityDao();
    }

    @Override
    public boolean addCertificateInfo(PersonInfoDTO dto) {
        CertificateInfoEntity entity = new CertificateInfoEntity();
        entity.setId(UUIDUtil.get32UUID());
        entity.setPersonInfoId(dto.getPersonInfoId());
        entity.setCertificateType(dto.getCertificateType());
        entity.setCertificateNo(dto.getCertificateNo());
        long result = mEntityDao.insert(entity);
        return result > 0;
    }
}