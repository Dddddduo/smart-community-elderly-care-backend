package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyanglaofuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyanglaofuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyanglaofuwuView;


/**
 * 养老服务评论表
 *
 * @author 
 * @email 
 * @date 2024-03-07 17:15:02
 */
public interface DiscussyanglaofuwuService extends IService<DiscussyanglaofuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyanglaofuwuVO> selectListVO(Wrapper<DiscussyanglaofuwuEntity> wrapper);
   	
   	DiscussyanglaofuwuVO selectVO(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);
   	
   	List<DiscussyanglaofuwuView> selectListView(Wrapper<DiscussyanglaofuwuEntity> wrapper);
   	
   	DiscussyanglaofuwuView selectView(@Param("ew") Wrapper<DiscussyanglaofuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyanglaofuwuEntity> wrapper);

   	

}

