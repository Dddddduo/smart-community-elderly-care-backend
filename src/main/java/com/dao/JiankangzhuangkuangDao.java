package com.dao;

import com.entity.JiankangzhuangkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiankangzhuangkuangVO;
import com.entity.view.JiankangzhuangkuangView;


/**
 * 健康状况
 * 
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public interface JiankangzhuangkuangDao extends BaseMapper<JiankangzhuangkuangEntity> {
	
	List<JiankangzhuangkuangVO> selectListVO(@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);
	
	JiankangzhuangkuangVO selectVO(@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);
	
	List<JiankangzhuangkuangView> selectListView(@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);

	List<JiankangzhuangkuangView> selectListView(Pagination page,@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);

	
	JiankangzhuangkuangView selectView(@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<JiankangzhuangkuangEntity> wrapper);



}
