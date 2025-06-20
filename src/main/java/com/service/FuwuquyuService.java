package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FuwuquyuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FuwuquyuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FuwuquyuView;


/**
 * 服务区域
 *
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public interface FuwuquyuService extends IService<FuwuquyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FuwuquyuVO> selectListVO(Wrapper<FuwuquyuEntity> wrapper);
   	
   	FuwuquyuVO selectVO(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);
   	
   	List<FuwuquyuView> selectListView(Wrapper<FuwuquyuEntity> wrapper);
   	
   	FuwuquyuView selectView(@Param("ew") Wrapper<FuwuquyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FuwuquyuEntity> wrapper);

   	

}

