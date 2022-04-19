package com.hzh.green.dao.sample.db.dao.impl;

import com.hzh.green.dao.sample.db.dao.IPersonMobileDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.entity.PersonMobileEntity;
import com.hzh.green.dao.sample.model.entity.PersonMobileEntityDao;
import com.hzh.green.dao.sample.util.GreenDaoManager;
import com.hzh.green.dao.sample.util.UUIDUtil;

import java.util.ArrayList;

/**
 * Package: com.hzh.green.dao.sample.db.dao.impl
 * FileName: PersonMobileDao
 * Date: on 2018/8/5  下午3:03
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonMobileDao implements IPersonMobileDao {
    private final PersonMobileEntityDao mEntityDao;

    public PersonMobileDao() {
        mEntityDao = GreenDaoManager.getInstance().getDaoSession().getPersonMobileEntityDao();
    }

    @Override
    public boolean addPersonMobile(PersonInfoDTO dto) {
        boolean result = false;
        try {
            String[] mobiles = dto.getMobiles();
            ArrayList<PersonMobileEntity> list = new ArrayList<>();
            for (String mobile : mobiles) {
                PersonMobileEntity entity = new PersonMobileEntity();
                entity.setId(UUIDUtil.get32UUID());
                entity.setPersonInfoId(dto.getPersonInfoId());
                entity.setMobileNum(mobile);
                list.add(entity);
            }
            mEntityDao.insertInTx(list);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}