package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.SaishiCommentbackDao;
import com.entity.SaishiCommentbackEntity;
import com.service.SaishiCommentbackService;
import com.entity.view.SaishiCommentbackView;

/**
 * 赛事评价 服务实现类
 */
@Service("saishiCommentbackService")
@Transactional
public class SaishiCommentbackServiceImpl extends ServiceImpl<SaishiCommentbackDao, SaishiCommentbackEntity> implements SaishiCommentbackService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<SaishiCommentbackView> page =new Query<SaishiCommentbackView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
