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

import com.entity.FuwuquyuEntity;
import com.entity.view.FuwuquyuView;

import com.service.FuwuquyuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务区域
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
@RestController
@RequestMapping("/fuwuquyu")
public class FuwuquyuController {
    @Autowired
    private FuwuquyuService fuwuquyuService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuquyuEntity fuwuquyu,
		HttpServletRequest request){
        EntityWrapper<FuwuquyuEntity> ew = new EntityWrapper<FuwuquyuEntity>();

		PageUtils page = fuwuquyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuquyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuquyuEntity fuwuquyu, 
		HttpServletRequest request){
        EntityWrapper<FuwuquyuEntity> ew = new EntityWrapper<FuwuquyuEntity>();

		PageUtils page = fuwuquyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuquyu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuquyuEntity fuwuquyu){
       	EntityWrapper<FuwuquyuEntity> ew = new EntityWrapper<FuwuquyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuquyu, "fuwuquyu")); 
        return R.ok().put("data", fuwuquyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuquyuEntity fuwuquyu){
        EntityWrapper< FuwuquyuEntity> ew = new EntityWrapper< FuwuquyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuquyu, "fuwuquyu")); 
		FuwuquyuView fuwuquyuView =  fuwuquyuService.selectView(ew);
		return R.ok("查询服务区域成功").put("data", fuwuquyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuquyuEntity fuwuquyu = fuwuquyuService.selectById(id);
        return R.ok().put("data", fuwuquyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuquyuEntity fuwuquyu = fuwuquyuService.selectById(id);
        return R.ok().put("data", fuwuquyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuquyuEntity fuwuquyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuquyu);
        fuwuquyuService.insert(fuwuquyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuquyuEntity fuwuquyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fuwuquyu);
        fuwuquyuService.insert(fuwuquyu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuquyuEntity fuwuquyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuquyu);
        fuwuquyuService.updateById(fuwuquyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuquyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
