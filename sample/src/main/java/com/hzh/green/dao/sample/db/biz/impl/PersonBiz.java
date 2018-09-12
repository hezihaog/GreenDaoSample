package com.hzh.green.dao.sample.db.biz.impl;

import com.hzh.green.dao.sample.common.model.vo.Page;
import com.hzh.green.dao.sample.common.model.vo.PageVO;
import com.hzh.green.dao.sample.db.biz.IPersonBiz;
import com.hzh.green.dao.sample.db.dao.IPersonDao;
import com.hzh.green.dao.sample.db.dao.impl.PersonDao;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;

import java.util.List;

/**
 * Package: com.github.wally.wcdb_sample.biz
 * FileName: PersonBiz
 * Date: on 2018/8/4  下午12:05
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public class PersonBiz implements IPersonBiz {
    private final IPersonDao mDao;

    public PersonBiz() {
        mDao = new PersonDao();
    }

    @Override
    public boolean addPerson(PersonInfoDTO dto) {
        return mDao.addPerson(dto);
    }

    @Override
    public boolean addPersons(List<PersonInfoDTO> dtos) {
        return mDao.addPersons(dtos);
    }

    @Override
    public PageVO<PersonInfoListVO> getAllPersonPageList(Integer pageNum, Integer pageSize) {
        Page<PersonInfoListVO> page = mDao.getAllPersonPageList(pageNum, pageSize);
        return new PageVO<>(page);
    }

    @Override
    public boolean hasData() {
        return mDao.hasData();
    }
}