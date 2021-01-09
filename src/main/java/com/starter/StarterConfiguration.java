package com.starter;

import com.starter.property.HandlerProperty;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({HandlerProperty.class})
public class StarterConfiguration
{
    @Bean
    public CustomPointcut getCustomPointcut(){
        return new CustomPointcut();
    }
    @Bean
    public ExceptionHandler getExceptionHandler(){
        return new ExceptionHandler();
    }

    @Bean
    public DefaultPointcutAdvisor declareParentsAdvisor(){
        return new DefaultPointcutAdvisor(getCustomPointcut(), getExceptionHandler());
    }

}
