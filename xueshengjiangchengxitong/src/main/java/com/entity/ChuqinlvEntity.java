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
 * 出勤率
 *
 * @author 
 * @email
 */
@TableName("chuqinlv")
public class ChuqinlvEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChuqinlvEntity() {

	}

	public ChuqinlvEntity(T t) {
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
     * 出勤率编号
     */
    @TableField(value = "chuqinlv_uuid_number")

    private String chuqinlvUuidNumber;


    /**
     * 月份
     */
    @TableField(value = "chuqinlv_yue")

    private String chuqinlvYue;


    /**
     * 出勤率
     */
    @TableField(value = "chuqinlv_name")

    private String chuqinlvName;


    /**
     * 出勤率分数
     */
    @TableField(value = "chuqinlv_fenshu")

    private Integer chuqinlvFenshu;


    /**
     * 出勤率详情
     */
    @TableField(value = "chuqinlv_content")

    private String chuqinlvContent;


    /**
     * 录入时间
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
	 * 设置：出勤率编号
	 */
    public String getChuqinlvUuidNumber() {
        return chuqinlvUuidNumber;
    }
    /**
	 * 获取：出勤率编号
	 */

    public void setChuqinlvUuidNumber(String chuqinlvUuidNumber) {
        this.chuqinlvUuidNumber = chuqinlvUuidNumber;
    }
    /**
	 * 设置：月份
	 */
    public String getChuqinlvYue() {
        return chuqinlvYue;
    }
    /**
	 * 获取：月份
	 */

    public void setChuqinlvYue(String chuqinlvYue) {
        this.chuqinlvYue = chuqinlvYue;
    }
    /**
	 * 设置：出勤率
	 */
    public String getChuqinlvName() {
        return chuqinlvName;
    }
    /**
	 * 获取：出勤率
	 */

    public void setChuqinlvName(String chuqinlvName) {
        this.chuqinlvName = chuqinlvName;
    }
    /**
	 * 设置：出勤率分数
	 */
    public Integer getChuqinlvFenshu() {
        return chuqinlvFenshu;
    }
    /**
	 * 获取：出勤率分数
	 */

    public void setChuqinlvFenshu(Integer chuqinlvFenshu) {
        this.chuqinlvFenshu = chuqinlvFenshu;
    }
    /**
	 * 设置：出勤率详情
	 */
    public String getChuqinlvContent() {
        return chuqinlvContent;
    }
    /**
	 * 获取：出勤率详情
	 */

    public void setChuqinlvContent(String chuqinlvContent) {
        this.chuqinlvContent = chuqinlvContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：录入时间
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
        return "Chuqinlv{" +
            "id=" + id +
            ", xueshengId=" + xueshengId +
            ", chuqinlvUuidNumber=" + chuqinlvUuidNumber +
            ", chuqinlvYue=" + chuqinlvYue +
            ", chuqinlvName=" + chuqinlvName +
            ", chuqinlvFenshu=" + chuqinlvFenshu +
            ", chuqinlvContent=" + chuqinlvContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
