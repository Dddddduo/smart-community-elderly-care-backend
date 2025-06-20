package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyanglaofuwuDao;
import com.entity.DiscussyanglaofuwuEntity;
import com.service.DiscussyanglaofuwuService;
import com.entity.vo.DiscussyanglaofuwuVO;
import com.entity.view.DiscussyanglaofuwuView;

@Service("discussyanglaofuwuService")
public class DiscussyanglaofuwuServiceImpl extends ServiceImpl<DiscussyanglaofuwuDao, DiscussyanglaofuwuEntity> implements DiscussyanglaofuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyanglaofuwuEntity> page = this.selectPage(
                new Query<DiscussyanglaofuwuEntity>(params).getPage(),
                new EntityWrapper<DiscussyanglaofuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyanglaofuwuEntity> wrapper) {
		  Page<DiscussyanglaofuwuView> page =new Query<DiscussyanglaofuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyanglaofuwuVO> selectListVO(Wrapper<DiscussyanglaofuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyanglaofuwuVO selectVO(Wrapper<DiscussyanglaofuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyanglaofuwuView> selectListView(Wrapper<DiscussyanglaofuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyanglaofuwuView selectView(Wrapper<DiscussyanglaofuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
