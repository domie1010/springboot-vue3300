package com.entity.model;

import com.entity.ChuqinlvEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出勤率
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChuqinlvModel implements Serializable {
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
     * 出勤率编号
     */
    private String chuqinlvUuidNumber;


    /**
     * 月份
     */
    private String chuqinlvYue;


    /**
     * 出勤率
     */
    private String chuqinlvName;


    /**
     * 出勤率分数
     */
    private Integer chuqinlvFenshu;


    /**
     * 出勤率详情
     */
    private String chuqinlvContent;


    /**
     * 录入时间
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
	 * 获取：出勤率编号
	 */
    public String getChuqinlvUuidNumber() {
        return chuqinlvUuidNumber;
    }


    /**
	 * 设置：出勤率编号
	 */
    public void setChuqinlvUuidNumber(String chuqinlvUuidNumber) {
        this.chuqinlvUuidNumber = chuqinlvUuidNumber;
    }
    /**
	 * 获取：月份
	 */
    public String getChuqinlvYue() {
        return chuqinlvYue;
    }


    /**
	 * 设置：月份
	 */
    public void setChuqinlvYue(String chuqinlvYue) {
        this.chuqinlvYue = chuqinlvYue;
    }
    /**
	 * 获取：出勤率
	 */
    public String getChuqinlvName() {
        return chuqinlvName;
    }


    /**
	 * 设置：出勤率
	 */
    public void setChuqinlvName(String chuqinlvName) {
        this.chuqinlvName = chuqinlvName;
    }
    /**
	 * 获取：出勤率分数
	 */
    public Integer getChuqinlvFenshu() {
        return chuqinlvFenshu;
    }


    /**
	 * 设置：出勤率分数
	 */
    public void setChuqinlvFenshu(Integer chuqinlvFenshu) {
        this.chuqinlvFenshu = chuqinlvFenshu;
    }
    /**
	 * 获取：出勤率详情
	 */
    public String getChuqinlvContent() {
        return chuqinlvContent;
    }


    /**
	 * 设置：出勤率详情
	 */
    public void setChuqinlvContent(String chuqinlvContent) {
        this.chuqinlvContent = chuqinlvContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
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
