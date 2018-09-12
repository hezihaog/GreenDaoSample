package com.hzh.green.dao.sample.db.dao;

import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;

/**
 * Package: com.hzh.green.dao.sample.db.dao
 * FileName: IPersonMobileDao
 * Date: on 2018/8/5  下午3:03
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public interface IPersonMobileDao {
    boolean addPersonMobile(PersonInfoDTO dto);
}