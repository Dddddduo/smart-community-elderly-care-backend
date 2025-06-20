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

import com.entity.HulirenyuanEntity;
import com.entity.view.HulirenyuanView;

import com.service.HulirenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 护理人员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
@RestController
@RequestMapping("/hulirenyuan")
public class HulirenyuanController {
    @Autowired
    private HulirenyuanService hulirenyuanService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HulirenyuanEntity u = hulirenyuanService.selectOne(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"hulirenyuan",  "护理人员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HulirenyuanEntity hulirenyuan){
    	//ValidatorUtils.validateEntity(hulirenyuan);
    	HulirenyuanEntity u = hulirenyuanService.selectOne(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", hulirenyuan.getHulizhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		hulirenyuan.setId(uId);
        hulirenyuanService.insert(hulirenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HulirenyuanEntity u = hulirenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HulirenyuanEntity u = hulirenyuanService.selectOne(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        hulirenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HulirenyuanEntity hulirenyuan,
		HttpServletRequest request){
        EntityWrapper<HulirenyuanEntity> ew = new EntityWrapper<HulirenyuanEntity>();

		PageUtils page = hulirenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hulirenyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HulirenyuanEntity hulirenyuan, 
		HttpServletRequest request){
        EntityWrapper<HulirenyuanEntity> ew = new EntityWrapper<HulirenyuanEntity>();

		PageUtils page = hulirenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hulirenyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HulirenyuanEntity hulirenyuan){
       	EntityWrapper<HulirenyuanEntity> ew = new EntityWrapper<HulirenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( hulirenyuan, "hulirenyuan")); 
        return R.ok().put("data", hulirenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HulirenyuanEntity hulirenyuan){
        EntityWrapper< HulirenyuanEntity> ew = new EntityWrapper< HulirenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( hulirenyuan, "hulirenyuan")); 
		HulirenyuanView hulirenyuanView =  hulirenyuanService.selectView(ew);
		return R.ok("查询护理人员成功").put("data", hulirenyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HulirenyuanEntity hulirenyuan = hulirenyuanService.selectById(id);
        return R.ok().put("data", hulirenyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HulirenyuanEntity hulirenyuan = hulirenyuanService.selectById(id);
        return R.ok().put("data", hulirenyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HulirenyuanEntity hulirenyuan, HttpServletRequest request){
        if(hulirenyuanService.selectCount(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", hulirenyuan.getHulizhanghao()))>0) {
            return R.error("护理账号已存在");
        }
    	hulirenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hulirenyuan);
    	HulirenyuanEntity u = hulirenyuanService.selectOne(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", hulirenyuan.getHulizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		hulirenyuan.setId(new Date().getTime());
        hulirenyuanService.insert(hulirenyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HulirenyuanEntity hulirenyuan, HttpServletRequest request){
        if(hulirenyuanService.selectCount(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", hulirenyuan.getHulizhanghao()))>0) {
            return R.error("护理账号已存在");
        }
    	hulirenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(hulirenyuan);
    	HulirenyuanEntity u = hulirenyuanService.selectOne(new EntityWrapper<HulirenyuanEntity>().eq("hulizhanghao", hulirenyuan.getHulizhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		hulirenyuan.setId(new Date().getTime());
        hulirenyuanService.insert(hulirenyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HulirenyuanEntity hulirenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(hulirenyuan);
        if(hulirenyuanService.selectCount(new EntityWrapper<HulirenyuanEntity>().ne("id", hulirenyuan.getId()).eq("hulizhanghao", hulirenyuan.getHulizhanghao()))>0) {
            return R.error("护理账号已存在");
        }
        hulirenyuanService.updateById(hulirenyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        hulirenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,HulirenyuanEntity hulirenyuan, HttpServletRequest request){
        EntityWrapper<HulirenyuanEntity> ew = new EntityWrapper<HulirenyuanEntity>();
        int count = hulirenyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, hulirenyuan), params), params));
        return R.ok().put("data", count);
    }



}
