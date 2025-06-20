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


import com.dao.XuanzefuwuDao;
import com.entity.XuanzefuwuEntity;
import com.service.XuanzefuwuService;
import com.entity.vo.XuanzefuwuVO;
import com.entity.view.XuanzefuwuView;

@Service("xuanzefuwuService")
public class XuanzefuwuServiceImpl extends ServiceImpl<XuanzefuwuDao, XuanzefuwuEntity> implements XuanzefuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuanzefuwuEntity> page = this.selectPage(
                new Query<XuanzefuwuEntity>(params).getPage(),
                new EntityWrapper<XuanzefuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuanzefuwuEntity> wrapper) {
		  Page<XuanzefuwuView> page =new Query<XuanzefuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XuanzefuwuVO> selectListVO(Wrapper<XuanzefuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuanzefuwuVO selectVO(Wrapper<XuanzefuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuanzefuwuView> selectListView(Wrapper<XuanzefuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuanzefuwuView selectView(Wrapper<XuanzefuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
