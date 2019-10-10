package com.example.demo.job;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-13:55
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
@TableName("quartz_task_log")
public class QuartzTaskLog extends Model<QuartzTaskLog> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体编号（唯一标识）
     */

    protected Long id;
    /**
     * 任务ID
     */
    @TableField("job_id")
    private Long jobId;
    /**
     * 定时任务名称
     */
    private String name;
    /**
     * 定制任务执行类
     */
    @TableField("target_bean")
    private String targetBean;
    /**
     * 定时任务执行方法
     */
    @TableField("trget_method")
    private String trgetMethod;
    /**
     * 执行参数
     */
    private String params;
    /**
     * 任务状态
     */
    private Integer status;
    /**
     * 异常消息
     */
    private String error;
    /**
     * 执行时间
     */
    private Integer times;

    /**
     *  创建者
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    protected Long createId;

    /**
     * 创建日期
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    @ApiModelProperty(hidden = true)
    protected Date createDate;

    /**
     * 更新者
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    protected Long updateId;

    /**
     * 更新日期
     */
    @TableField(value = "update_date", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(hidden = true)
    protected Date updateDate;

    /**
     * 删除标记（Y：正常；N：删除；A：审核；）
     */
    @TableField(value = "del_flag")
    @ApiModelProperty(example = "0",hidden = true)
    protected Boolean delFlag;

    /**
     * 备注
     */
    @TableField(strategy= FieldStrategy.IGNORED)
    @ApiModelProperty(hidden = true)
    protected String remarks;

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
