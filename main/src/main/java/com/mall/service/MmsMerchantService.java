package com.mall.service;

import com.mall.common.exception.NotExistException;
import com.mall.common.utils.ThreadLocalUtil;
import com.mall.mbg.mapper.MmsMerchantMapper;
import com.mall.mbg.model.MmsMerchant;
import com.mall.mbg.model.MmsMerchantExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 帐套信息查询服务
 *
 * @author 李重辰
 * @date 2020/10/16 10:02
 */
@Service
public class MmsMerchantService {

    @Resource
    private MmsMerchantMapper merchantMapper;

    /**
     * 获得当前帐套的商家信息
     * TODO: 2020/10/16 14:32 建立公共工具类而不是在service之前互相调用
     */
    public MmsMerchant getMerchant() {
        String corpNo = ThreadLocalUtil.getMerchant();
        MmsMerchantExample merchantExample = new MmsMerchantExample();
        merchantExample.createCriteria().andIdEqualTo(corpNo);
        List<MmsMerchant> mmsMerchants = merchantMapper.selectByExample(merchantExample);
        if (mmsMerchants.isEmpty()) {
            throw new NotExistException(corpNo) {
                private static final long serialVersionUID = 6050177740042446069L;

                @Override
                protected String getType() {
                    return "帐套";
                }
            };
        }
        return mmsMerchants.get(0);
    }

    /**
     * 所有的商家信息
     */
    public List<MmsMerchant> listMerchant() {
        return merchantMapper.selectByExample(new MmsMerchantExample());
    }
}
