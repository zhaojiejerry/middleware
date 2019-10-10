package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.job.QuartzTask;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * author:lizhaojie
 * 创建日期:2019/9/27-14:17
 */
public interface QuartzTaskDao extends BaseMapper<QuartzTask> {

}
