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


import com.dao.FuwuquyuDao;
import com.entity.FuwuquyuEntity;
import com.service.FuwuquyuService;
import com.entity.vo.FuwuquyuVO;
import com.entity.view.FuwuquyuView;

@Service("fuwuquyuService")
public class FuwuquyuServiceImpl extends ServiceImpl<FuwuquyuDao, FuwuquyuEntity> implements FuwuquyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuquyuEntity> page = this.selectPage(
                new Query<FuwuquyuEntity>(params).getPage(),
                new EntityWrapper<FuwuquyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuquyuEntity> wrapper) {
		  Page<FuwuquyuView> page =new Query<FuwuquyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FuwuquyuVO> selectListVO(Wrapper<FuwuquyuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FuwuquyuVO selectVO(Wrapper<FuwuquyuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FuwuquyuView> selectListView(Wrapper<FuwuquyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuquyuView selectView(Wrapper<FuwuquyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
