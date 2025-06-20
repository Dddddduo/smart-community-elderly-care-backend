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

import com.entity.ShequEntity;
import com.entity.view.ShequView;

import com.service.ShequService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 社区
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
@RestController
@RequestMapping("/shequ")
public class ShequController {
    @Autowired
    private ShequService shequService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShequEntity shequ,
		HttpServletRequest request){
        EntityWrapper<ShequEntity> ew = new EntityWrapper<ShequEntity>();

		PageUtils page = shequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequ), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShequEntity shequ, 
		HttpServletRequest request){
        EntityWrapper<ShequEntity> ew = new EntityWrapper<ShequEntity>();

		PageUtils page = shequService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shequ), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShequEntity shequ){
       	EntityWrapper<ShequEntity> ew = new EntityWrapper<ShequEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shequ, "shequ")); 
        return R.ok().put("data", shequService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShequEntity shequ){
        EntityWrapper< ShequEntity> ew = new EntityWrapper< ShequEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shequ, "shequ")); 
		ShequView shequView =  shequService.selectView(ew);
		return R.ok("查询社区成功").put("data", shequView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShequEntity shequ = shequService.selectById(id);
        return R.ok().put("data", shequ);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShequEntity shequ = shequService.selectById(id);
        return R.ok().put("data", shequ);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShequEntity shequ, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shequ);
        shequService.insert(shequ);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShequEntity shequ, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shequ);
        shequService.insert(shequ);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShequEntity shequ, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shequ);
        shequService.updateById(shequ);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shequService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
