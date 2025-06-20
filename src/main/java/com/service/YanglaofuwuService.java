package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YanglaofuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YanglaofuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YanglaofuwuView;


/**
 * 养老服务
 *
 * @author 
 * @email 
 * @date 2024-03-07 17:15:00
 */
public interface YanglaofuwuService extends IService<YanglaofuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YanglaofuwuVO> selectListVO(Wrapper<YanglaofuwuEntity> wrapper);
   	
   	YanglaofuwuVO selectVO(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);
   	
   	List<YanglaofuwuView> selectListView(Wrapper<YanglaofuwuEntity> wrapper);
   	
   	YanglaofuwuView selectView(@Param("ew") Wrapper<YanglaofuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YanglaofuwuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YanglaofuwuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YanglaofuwuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YanglaofuwuEntity> wrapper);



}

