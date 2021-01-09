package com.starter.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "exception.handler")
public class HandlerProperty
{
    private List<String> packages;
}
