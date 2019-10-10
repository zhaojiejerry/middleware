package com.example.demo.job;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-13:46
 */

@ToString
@ApiModel
@TableName("quartz_task")
@Data
public class QuartzTask extends Model<QuartzTaskLog> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 实体编号（唯一标识）
     */

    protected Long id;
    /**
     * 任务调度参数key
     */
    @TableField(exist = false)
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";
    /**
     * 任务名称
     */
    @ApiModelProperty(example = "Quartz-Hello")
    private String name;
    /**
     * 任务表达式
     */
    @ApiModelProperty(example = "3 * * * * ? ")
    private String cron;
    /**
     * 执行的类
     */
    @TableField("target_bean")
    @ApiModelProperty(example = "helloTask")
    private String targetBean;
    /**
     * 执行方法
     */
    @TableField("trget_method")
    @ApiModelProperty(example = "executeMethod")
    private String trgetMethod;
    /**
     * 执行参数
     */
    @ApiModelProperty(example = "Hello-Word!")
    private String params;
    /**
     * 任务类型-
     */
    @TableField("quartz_type")
    @ApiModelProperty(example = "API_GROUPS")
    private String quartzType;
    /**
     * 任务状态 0:正常  1：暂停
     */
    @ApiModelProperty(example = "0")
    private Integer status;

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
    protected Boolean delFlag = false;

    /**
     * 备注
     */
    @TableField(strategy= FieldStrategy.IGNORED)
    @ApiModelProperty(hidden = true)
    protected String remarks = "remarks";

    /**
     * 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
