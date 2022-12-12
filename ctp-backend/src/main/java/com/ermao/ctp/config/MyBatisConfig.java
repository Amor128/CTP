package com.ermao.ctp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ermao
 * Date: 2022/12/12 16:38
 */
@Configuration
public class MyBatisConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor  getMybatisPlusInterceptor () {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
