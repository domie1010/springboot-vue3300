package com.entity.vo;

import com.entity.ChuqinlvEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出勤率
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuqinlv")
public class ChuqinlvVO implements Serializable {
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

}
