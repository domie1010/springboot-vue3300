package com.entity.model;

import com.entity.FenshujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 分数记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FenshujiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 记录类型
     */
    private Integer fenshujiluTypes;


    /**
     * 记录分数
     */
    private Integer fenshujiluFenshu;


    /**
     * 记录详情
     */
    private String fenshujiluContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：记录类型
	 */
    public Integer getFenshujiluTypes() {
        return fenshujiluTypes;
    }


    /**
	 * 设置：记录类型
	 */
    public void setFenshujiluTypes(Integer fenshujiluTypes) {
        this.fenshujiluTypes = fenshujiluTypes;
    }
    /**
	 * 获取：记录分数
	 */
    public Integer getFenshujiluFenshu() {
        return fenshujiluFenshu;
    }


    /**
	 * 设置：记录分数
	 */
    public void setFenshujiluFenshu(Integer fenshujiluFenshu) {
        this.fenshujiluFenshu = fenshujiluFenshu;
    }
    /**
	 * 获取：记录详情
	 */
    public String getFenshujiluContent() {
        return fenshujiluContent;
    }


    /**
	 * 设置：记录详情
	 */
    public void setFenshujiluContent(String fenshujiluContent) {
        this.fenshujiluContent = fenshujiluContent;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
