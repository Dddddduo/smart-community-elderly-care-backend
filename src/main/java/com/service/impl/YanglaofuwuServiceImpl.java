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


import com.dao.YanglaofuwuDao;
import com.entity.YanglaofuwuEntity;
import com.service.YanglaofuwuService;
import com.entity.vo.YanglaofuwuVO;
import com.entity.view.YanglaofuwuView;

@Service("yanglaofuwuService")
public class YanglaofuwuServiceImpl extends ServiceImpl<YanglaofuwuDao, YanglaofuwuEntity> implements YanglaofuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YanglaofuwuEntity> page = this.selectPage(
                new Query<YanglaofuwuEntity>(params).getPage(),
                new EntityWrapper<YanglaofuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YanglaofuwuEntity> wrapper) {
		  Page<YanglaofuwuView> page =new Query<YanglaofuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YanglaofuwuVO> selectListVO(Wrapper<YanglaofuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YanglaofuwuVO selectVO(Wrapper<YanglaofuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YanglaofuwuView> selectListView(Wrapper<YanglaofuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YanglaofuwuView selectView(Wrapper<YanglaofuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YanglaofuwuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YanglaofuwuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YanglaofuwuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
