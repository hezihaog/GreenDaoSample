package com.hzh.green.dao.sample.db.biz;


import com.hzh.green.dao.sample.common.model.vo.PageVO;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;

import java.util.List;

/**
 * Package: com.github.wally.wcdb_sample.biz
 * FileName: IPersonBiz
 * Date: on 2018/8/4  下午12:11
 * Auther: zihe
 * Descirbe:
 * Email: hezihao@linghit.com
 */
public interface IPersonBiz {
    boolean addPerson(PersonInfoDTO dto);

    boolean addPersons(List<PersonInfoDTO> dtos);

    PageVO<PersonInfoListVO> getAllPersonPageList(Integer pageNum, Integer pageSize);

    boolean hasData();
}