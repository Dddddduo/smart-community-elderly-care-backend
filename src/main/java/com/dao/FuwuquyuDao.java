package com.dao;

import com.entity.FuwuquyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FuwuquyuVO;
import com.entity.view.FuwuquyuView;


/**
 * 服务区域
 * 
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public interface FuwuquyuDao extends BaseMapper<FuwuquyuEntity> {
	
	List<FuwuquyuVO> selectListVO(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);
	
	FuwuquyuVO selectVO(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);
	
	List<FuwuquyuView> selectListView(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);

	List<FuwuquyuView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuquyuEntity> wrapper);

	
	FuwuquyuView selectView(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);
	

}
