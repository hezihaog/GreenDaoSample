package com.hzh.green.dao.sample.db.aggr;

import android.text.TextUtils;

import com.hzh.green.dao.sample.common.model.vo.PageVO;
import com.hzh.green.dao.sample.db.biz.ICertificateInfoBiz;
import com.hzh.green.dao.sample.db.biz.IPersonBiz;
import com.hzh.green.dao.sample.db.biz.IPersonMobileBiz;
import com.hzh.green.dao.sample.db.biz.impl.CertificateInfoBiz;
import com.hzh.green.dao.sample.db.biz.impl.PersonBiz;
import com.hzh.green.dao.sample.db.biz.impl.PersonMobileBiz;
import com.hzh.green.dao.sample.model.dto.PersonInfoDTO;
import com.hzh.green.dao.sample.model.vo.PersonInfoListVO;

/**
 * Package: com.hzh.green.dao.sample.db.aggr
 * FileName: IAggrPersonController
 * Date: on 2018/8/5  下午2:24
 * Auther: zihe
 * Descirbe:聚合控制器
 * Email: hezihao@linghit.com
 */
public class AggrPersonController {
    private IPersonBiz mPersonBiz = new PersonBiz();
    private IPersonMobileBiz mPersonMobileBiz = new PersonMobileBiz();
    private ICertificateInfoBiz mCertificateInfoBiz = new CertificateInfoBiz();

    /**
     * 增加住户
     */
    public boolean addPersonInfo(PersonInfoDTO dto) {
        boolean result = false;
        //增加住户信息
        result = mPersonBiz.addPerson(dto);
        String[] mobiles = dto.getMobiles();
        if (mobiles != null && mobiles.length > 0) {
            //增加住户手机号
            result = mPersonMobileBiz.addPersonMobile(dto);
        }
        String certificateType = dto.getCertificateType();
        String certificateNo = dto.getCertificateNo();
        if (!TextUtils.isEmpty(certificateType) && !TextUtils.isEmpty(certificateNo)) {
            //增加住户证件信息
            result = mCertificateInfoBiz.addCertificateInfo(dto);
        }
        return result;
    }

    public boolean hasData() {
        return mPersonBiz.hasData();
    }

    public PageVO<PersonInfoListVO> getAllPersonPageList(int page, int pageSize) {
        return mPersonBiz.getAllPersonPageList(page, pageSize);
    }
}