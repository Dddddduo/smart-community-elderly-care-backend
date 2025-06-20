package com.entity.model;

import com.entity.JiankangzhuangkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 健康状况
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
public class JiankangzhuangkuangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 出生日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chushengriqi;
		
	/**
	 * 血压
	 */
	
	private Double xueya;
		
	/**
	 * 血糖
	 */
	
	private Double xuetang;
		
	/**
	 * 心率
	 */
	
	private Double xinlv;
		
	/**
	 * 生活习惯
	 */
	
	private String shenghuoxiguan;
		
	/**
	 * 以往病史
	 */
	
	private String yiwangbingshi;
		
	/**
	 * 慢性病
	 */
	
	private String manxingbing;
		
	/**
	 * 健康状况
	 */
	
	private String jiankangzhuangkuang;
		
	/**
	 * 登记日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
		
	/**
	 * 护理账号
	 */
	
	private String hulizhanghao;
		
	/**
	 * 护理姓名
	 */
	
	private String hulixingming;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：出生日期
	 */
	 
	public void setChushengriqi(Date chushengriqi) {
		this.chushengriqi = chushengriqi;
	}
	
	/**
	 * 获取：出生日期
	 */
	public Date getChushengriqi() {
		return chushengriqi;
	}
				
	
	/**
	 * 设置：血压
	 */
	 
	public void setXueya(Double xueya) {
		this.xueya = xueya;
	}
	
	/**
	 * 获取：血压
	 */
	public Double getXueya() {
		return xueya;
	}
				
	
	/**
	 * 设置：血糖
	 */
	 
	public void setXuetang(Double xuetang) {
		this.xuetang = xuetang;
	}
	
	/**
	 * 获取：血糖
	 */
	public Double getXuetang() {
		return xuetang;
	}
				
	
	/**
	 * 设置：心率
	 */
	 
	public void setXinlv(Double xinlv) {
		this.xinlv = xinlv;
	}
	
	/**
	 * 获取：心率
	 */
	public Double getXinlv() {
		return xinlv;
	}
				
	
	/**
	 * 设置：生活习惯
	 */
	 
	public void setShenghuoxiguan(String shenghuoxiguan) {
		this.shenghuoxiguan = shenghuoxiguan;
	}
	
	/**
	 * 获取：生活习惯
	 */
	public String getShenghuoxiguan() {
		return shenghuoxiguan;
	}
				
	
	/**
	 * 设置：以往病史
	 */
	 
	public void setYiwangbingshi(String yiwangbingshi) {
		this.yiwangbingshi = yiwangbingshi;
	}
	
	/**
	 * 获取：以往病史
	 */
	public String getYiwangbingshi() {
		return yiwangbingshi;
	}
				
	
	/**
	 * 设置：慢性病
	 */
	 
	public void setManxingbing(String manxingbing) {
		this.manxingbing = manxingbing;
	}
	
	/**
	 * 获取：慢性病
	 */
	public String getManxingbing() {
		return manxingbing;
	}
				
	
	/**
	 * 设置：健康状况
	 */
	 
	public void setJiankangzhuangkuang(String jiankangzhuangkuang) {
		this.jiankangzhuangkuang = jiankangzhuangkuang;
	}
	
	/**
	 * 获取：健康状况
	 */
	public String getJiankangzhuangkuang() {
		return jiankangzhuangkuang;
	}
				
	
	/**
	 * 设置：登记日期
	 */
	 
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}
				
	
	/**
	 * 设置：护理账号
	 */
	 
	public void setHulizhanghao(String hulizhanghao) {
		this.hulizhanghao = hulizhanghao;
	}
	
	/**
	 * 获取：护理账号
	 */
	public String getHulizhanghao() {
		return hulizhanghao;
	}
				
	
	/**
	 * 设置：护理姓名
	 */
	 
	public void setHulixingming(String hulixingming) {
		this.hulixingming = hulixingming;
	}
	
	/**
	 * 获取：护理姓名
	 */
	public String getHulixingming() {
		return hulixingming;
	}
			
}
