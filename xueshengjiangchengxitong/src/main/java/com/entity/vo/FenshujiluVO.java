package com.entity.vo;

import com.entity.FenshujiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 分数记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fenshujilu")
public class FenshujiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 记录类型
     */

    @TableField(value = "fenshujilu_types")
    private Integer fenshujiluTypes;


    /**
     * 记录分数
     */

    @TableField(value = "fenshujilu_fenshu")
    private Integer fenshujiluFenshu;


    /**
     * 记录详情
     */

    @TableField(value = "fenshujilu_content")
    private String fenshujiluContent;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：记录类型
	 */
    public Integer getFenshujiluTypes() {
        return fenshujiluTypes;
    }


    /**
	 * 获取：记录类型
	 */

    public void setFenshujiluTypes(Integer fenshujiluTypes) {
        this.fenshujiluTypes = fenshujiluTypes;
    }
    /**
	 * 设置：记录分数
	 */
    public Integer getFenshujiluFenshu() {
        return fenshujiluFenshu;
    }


    /**
	 * 获取：记录分数
	 */

    public void setFenshujiluFenshu(Integer fenshujiluFenshu) {
        this.fenshujiluFenshu = fenshujiluFenshu;
    }
    /**
	 * 设置：记录详情
	 */
    public String getFenshujiluContent() {
        return fenshujiluContent;
    }


    /**
	 * 获取：记录详情
	 */

    public void setFenshujiluContent(String fenshujiluContent) {
        this.fenshujiluContent = fenshujiluContent;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：记录时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
