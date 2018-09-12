package com.hzh.green.dao.sample.db.dao;


import com.hzh.green.dao.sample.common.model.vo.Page;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;

import java.util.List;

/**
 * Package: com.github.wally.wcdb_sample.dao
 * FileName: IPersonDao
 * Date: on 2018/8/4  下午12:28
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public interface IPersonDao {
    boolean addPerson(PersonInfoDTO dto);

    boolean addPersons(List<PersonInfoDTO> dtos);

    Page<PersonInfoListVO> getAllPersonPageList(Integer pageNum, Integer pageSize);

    long getTotalCount();

    boolean hasData();
}