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
 * 分数记录
 *
 * @author 
 * @email
 */
@TableName("fenshujilu")
public class FenshujiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FenshujiluEntity() {

	}

	public FenshujiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Fenshujilu{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", fenshujiluTypes=" + fenshujiluTypes +
            ", fenshujiluFenshu=" + fenshujiluFenshu +
            ", fenshujiluContent=" + fenshujiluContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
