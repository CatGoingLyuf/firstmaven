package com.lyuf.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author lyuf
 * @date 2020/9/23 21:04
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();//数据源，可替换
    }
}
