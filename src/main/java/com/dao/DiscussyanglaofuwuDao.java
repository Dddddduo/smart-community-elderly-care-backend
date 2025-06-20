package com.dao;

import com.entity.DiscussyanglaofuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyanglaofuwuVO;
import com.entity.view.DiscussyanglaofuwuView;


/**
 * 养老服务评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-07 17:15:02
 */
public interface DiscussyanglaofuwuDao extends BaseMapper<DiscussyanglaofuwuEntity> {
	
	List<DiscussyanglaofuwuVO> selectListVO(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);
	
	DiscussyanglaofuwuVO selectVO(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);
	
	List<DiscussyanglaofuwuView> selectListView(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);

	List<DiscussyanglaofuwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);

	
	DiscussyanglaofuwuView selectView(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);
	

}
