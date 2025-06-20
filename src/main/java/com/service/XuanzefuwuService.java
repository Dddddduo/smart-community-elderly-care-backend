package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuanzefuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuanzefuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanzefuwuView;


/**
 * 选择服务
 *
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public interface XuanzefuwuService extends IService<XuanzefuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuanzefuwuVO> selectListVO(Wrapper<XuanzefuwuEntity> wrapper);
   	
   	XuanzefuwuVO selectVO(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);
   	
   	List<XuanzefuwuView> selectListView(Wrapper<XuanzefuwuEntity> wrapper);
   	
   	XuanzefuwuView selectView(@Param("ew") Wrapper<XuanzefuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuanzefuwuEntity> wrapper);

   	

}

