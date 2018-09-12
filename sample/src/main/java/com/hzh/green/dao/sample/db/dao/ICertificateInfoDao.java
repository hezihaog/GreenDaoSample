package com.hzh.green.dao.sample.db.dao;

import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;

/**
 * Package: com.hzh.green.dao.sample.db.dao
 * FileName: ICertificateInfoDao
 * Date: on 2018/8/5  下午3:04
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public interface ICertificateInfoDao {
    boolean addCertificateInfo(PersonInfoDTO dto);
}