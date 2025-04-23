package com.entity.model;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChengjiModel implements Serializable {
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
     * 成绩编号
     */
    private String chengjiUuidNumber;


    /**
     * 成绩名称
     */
    private String chengjiName;


    /**
     * 成绩类型
     */
    private Integer chengjiTypes;


    /**
     * 成绩详情
     */
    private String chengjiContent;


    /**
     * 成绩分数
     */
    private Integer chengjiFenshu;


    /**
     * 所得分数
     */
    private Integer chengjiDedaoFenshu;


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
	 * 获取：成绩编号
	 */
    public String getChengjiUuidNumber() {
        return chengjiUuidNumber;
    }


    /**
	 * 设置：成绩编号
	 */
    public void setChengjiUuidNumber(String chengjiUuidNumber) {
        this.chengjiUuidNumber = chengjiUuidNumber;
    }
    /**
	 * 获取：成绩名称
	 */
    public String getChengjiName() {
        return chengjiName;
    }


    /**
	 * 设置：成绩名称
	 */
    public void setChengjiName(String chengjiName) {
        this.chengjiName = chengjiName;
    }
    /**
	 * 获取：成绩类型
	 */
    public Integer getChengjiTypes() {
        return chengjiTypes;
    }


    /**
	 * 设置：成绩类型
	 */
    public void setChengjiTypes(Integer chengjiTypes) {
        this.chengjiTypes = chengjiTypes;
    }
    /**
	 * 获取：成绩详情
	 */
    public String getChengjiContent() {
        return chengjiContent;
    }


    /**
	 * 设置：成绩详情
	 */
    public void setChengjiContent(String chengjiContent) {
        this.chengjiContent = chengjiContent;
    }
    /**
	 * 获取：成绩分数
	 */
    public Integer getChengjiFenshu() {
        return chengjiFenshu;
    }


    /**
	 * 设置：成绩分数
	 */
    public void setChengjiFenshu(Integer chengjiFenshu) {
        this.chengjiFenshu = chengjiFenshu;
    }
    /**
	 * 获取：所得分数
	 */
    public Integer getChengjiDedaoFenshu() {
        return chengjiDedaoFenshu;
    }


    /**
	 * 设置：所得分数
	 */
    public void setChengjiDedaoFenshu(Integer chengjiDedaoFenshu) {
        this.chengjiDedaoFenshu = chengjiDedaoFenshu;
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
