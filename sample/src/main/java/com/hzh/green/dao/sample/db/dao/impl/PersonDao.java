package com.hzh.green.dao.sample.db.dao.impl;


import com.hzh.green.dao.sample.common.model.vo.Page;
import com.hzh.green.dao.sample.db.dao.IPersonDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.entity.PersonInfoEntity;
import com.hzh.green.dao.sample.model.entity.PersonInfoEntityDao;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;
import com.hzh.green.dao.sample.util.GreenDaoManager;
import com.hzh.green.dao.sample.util.PageHelper;
import com.hzh.green.dao.sample.util.UUIDUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.github.wally.wcdb_sample.dao
 * FileName: PersonDao
 * Date: on 2018/8/4  下午12:06
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonDao implements IPersonDao {
    private final PersonInfoEntityDao mEntityDao;

    public PersonDao() {
        mEntityDao = GreenDaoManager.getInstance().getDaoSession().getPersonInfoEntityDao();
    }

    @Override
    public boolean addPerson(PersonInfoDTO dto) {
        boolean result = false;
        PersonInfoEntity entity = buildEntity(dto);
        try {
            long id = mEntityDao.insert(entity);
            dto.setPersonInfoId(entity.getId());
            result = id > 0;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public boolean addPersons(List<PersonInfoDTO> dtos) {
        boolean result = false;
        ArrayList<PersonInfoEntity> entitys = new ArrayList<>();
        for (PersonInfoDTO dto : dtos) {
            PersonInfoEntity entity = buildEntity(dto);
            entitys.add(entity);
        }
        try {
            mEntityDao.insertInTx(entitys);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public Page<PersonInfoListVO> getAllPersonPageList(Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 15;
        }
        List<PersonInfoListVO> resultList = new ArrayList<>();
        //计算起始位置和偏移量
        int startIndex = PageHelper.calculatePageStartIndex(pageNum, pageSize);
        //查询总条数
        PageHelper<PersonInfoListVO> helper = new PageHelper<>();
        long totalCount = getTotalCount();
        Page<PersonInfoListVO> pageVO = helper.handlePage(pageSize, totalCount, pageNum);
        //这个offset指的是分页偏移量
        int offset = pageSize;
        List<PersonInfoEntity> list = mEntityDao.queryBuilder()
                .orderDesc(PersonInfoEntityDao.Properties.Id)
                .offset(startIndex)
                .limit(offset)
                .list();

//        List<PersonInfoEntity> list = new ArrayList<>();
//        String sql = "select * from " + PersonInfoEntityDao.TABLENAME + " limit " + startIndex + "," + offset;
//        Cursor cursor = mEntityDao.getSession().getDatabase().rawQuery(sql, null);
//        while (cursor.moveToNext()) {
//            PersonInfoEntity entity = new PersonInfoEntity();
//            entity.setId(cursor.getString(cursor.getColumnIndex(PersonInfoEntityDao.Properties.Id.columnName)));
//            entity.setPersonName(cursor.getString(cursor.getColumnIndex(PersonInfoEntityDao.Properties.PersonName.columnName)));
//            entity.setSex(cursor.getString(cursor.getColumnIndex(PersonInfoEntityDao.Properties.Sex.columnName)));
//            entity.setAge(cursor.getInt(cursor.getColumnIndex(PersonInfoEntityDao.Properties.Age.columnName)));
//            entity.setDeleteFlag(cursor.getInt(cursor.getColumnIndex(PersonInfoEntityDao.Properties.DeleteFlag.columnName)));
//            String createTimeStr = cursor.getString(cursor.getColumnIndex(PersonInfoEntityDao.Properties.CreateTime.columnName));
//            entity.setCreateTime(DateUtil.formatDate(createTimeStr, DateUtil.FORMAT_NORMAL));
//            String updateTimeStr = cursor.getString(cursor.getColumnIndex(PersonInfoEntityDao.Properties.UpdateTime.columnName));
//            entity.setUpdateTime(DateUtil.formatDate(updateTimeStr));
//            entity.setVersion(cursor.getInt(cursor.getColumnIndex(PersonInfoEntityDao.Properties.Version.columnName)));
//            list.add(entity);
//        }

        for (PersonInfoEntity entity : list) {
            PersonInfoListVO vo = buildVO(entity);
            resultList.add(vo);
        }
        pageVO.setRecords(resultList);
        return pageVO;
    }

    @Override
    public long getTotalCount() {
        return mEntityDao.count();
    }

    @Override
    public boolean hasData() {
        long count = getTotalCount();
        return count > 0;
    }

    private PersonInfoEntity buildEntity(PersonInfoDTO dto) {
        PersonInfoEntity entity = new PersonInfoEntity();
        entity.setId(UUIDUtil.get32UUID());
        entity.setPersonName(dto.getPersonName());
        entity.setSex(dto.getSex());
        entity.setAge(dto.getAge());
        return entity;
    }

    private PersonInfoListVO buildVO(PersonInfoEntity entity) {
        PersonInfoListVO vo = new PersonInfoListVO();
        vo.setId(entity.getId());
        vo.setPersonName(entity.getPersonName());
        vo.setSex(entity.getSex());
        vo.setAge(entity.getAge());
        vo.setCreateTime(entity.getCreateTime());
        vo.setUpdateTime(entity.getUpdateTime());
        return vo;
    }
}