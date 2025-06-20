package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.XuanzefuwuEntity;
import com.entity.view.XuanzefuwuView;

import com.service.XuanzefuwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 选择服务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
@RestController
@RequestMapping("/xuanzefuwu")
public class XuanzefuwuController {
    @Autowired
    private XuanzefuwuService xuanzefuwuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuanzefuwuEntity xuanzefuwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xuanzefuwu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuanzefuwuEntity> ew = new EntityWrapper<XuanzefuwuEntity>();

		PageUtils page = xuanzefuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanzefuwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuanzefuwuEntity xuanzefuwu, 
		HttpServletRequest request){
        EntityWrapper<XuanzefuwuEntity> ew = new EntityWrapper<XuanzefuwuEntity>();

		PageUtils page = xuanzefuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuanzefuwu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuanzefuwuEntity xuanzefuwu){
       	EntityWrapper<XuanzefuwuEntity> ew = new EntityWrapper<XuanzefuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuanzefuwu, "xuanzefuwu")); 
        return R.ok().put("data", xuanzefuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuanzefuwuEntity xuanzefuwu){
        EntityWrapper< XuanzefuwuEntity> ew = new EntityWrapper< XuanzefuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuanzefuwu, "xuanzefuwu")); 
		XuanzefuwuView xuanzefuwuView =  xuanzefuwuService.selectView(ew);
		return R.ok("查询选择服务成功").put("data", xuanzefuwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuanzefuwuEntity xuanzefuwu = xuanzefuwuService.selectById(id);
        return R.ok().put("data", xuanzefuwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuanzefuwuEntity xuanzefuwu = xuanzefuwuService.selectById(id);
        return R.ok().put("data", xuanzefuwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuanzefuwuEntity xuanzefuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xuanzefuwu);
        xuanzefuwuService.insert(xuanzefuwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuanzefuwuEntity xuanzefuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xuanzefuwu);
        xuanzefuwuService.insert(xuanzefuwu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuanzefuwuEntity xuanzefuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuanzefuwu);
        xuanzefuwuService.updateById(xuanzefuwu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XuanzefuwuEntity> list = new ArrayList<XuanzefuwuEntity>();
        for(Long id : ids) {
            XuanzefuwuEntity xuanzefuwu = xuanzefuwuService.selectById(id);
            xuanzefuwu.setSfsh(sfsh);
            xuanzefuwu.setShhf(shhf);
            list.add(xuanzefuwu);
        }
        xuanzefuwuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuanzefuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
