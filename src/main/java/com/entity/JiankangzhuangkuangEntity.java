package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 健康状况
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-07 17:15:01
 */
@TableName("jiankangzhuangkuang")
public class JiankangzhuangkuangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiankangzhuangkuangEntity() {
		
	}
	
	public JiankangzhuangkuangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
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
