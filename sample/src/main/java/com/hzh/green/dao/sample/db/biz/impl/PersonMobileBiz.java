package com.hzh.green.dao.sample.db.biz.impl;

import com.hzh.green.dao.sample.db.biz.IPersonMobileBiz;
import com.hzh.green.dao.sample.db.dao.IPersonMobileDao;
import com.hzh.green.dao.sample.db.dao.impl.PersonMobileDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;

/**
 * Package: com.hzh.green.dao.sample.db.biz.impl
 * FileName: PersonMobileBiz
 * Date: on 2018/8/5  下午2:55
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonMobileBiz implements IPersonMobileBiz {
    private final IPersonMobileDao mDao;

    public PersonMobileBiz() {
        mDao = new PersonMobileDao();
    }

    @Override
    public boolean addPersonMobile(PersonInfoDTO dto) {
        return mDao.addPersonMobile(dto);
    }
}