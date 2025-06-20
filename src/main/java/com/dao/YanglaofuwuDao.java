package com.dao;

import com.entity.YanglaofuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YanglaofuwuVO;
import com.entity.view.YanglaofuwuView;


/**
 * 养老服务
 * 
 * @author 
 * @email 
 * @date 2024-03-07 17:15:00
 */
public interface YanglaofuwuDao extends BaseMapper<YanglaofuwuEntity> {
	
	List<YanglaofuwuVO> selectListVO(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);
	
	YanglaofuwuVO selectVO(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);
	
	List<YanglaofuwuView> selectListView(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);

	List<YanglaofuwuView> selectListView(Pagination page,@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);

	
	YanglaofuwuView selectView(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);



}
