package com.dao;

import com.entity.XuanzefuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuanzefuwuVO;
import com.entity.view.XuanzefuwuView;


/**
 * 选择服务
 * 
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public interface XuanzefuwuDao extends BaseMapper<XuanzefuwuEntity> {
	
	List<XuanzefuwuVO> selectListVO(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);
	
	XuanzefuwuVO selectVO(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);
	
	List<XuanzefuwuView> selectListView(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);

	List<XuanzefuwuView> selectListView(Pagination page,@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);

	
	XuanzefuwuView selectView(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);
	

}
