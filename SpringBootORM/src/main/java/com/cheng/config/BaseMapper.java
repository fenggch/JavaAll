package com.cheng.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-08
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
