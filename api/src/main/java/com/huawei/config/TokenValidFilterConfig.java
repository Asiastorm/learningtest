package com.huawei.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "token-allow-list")
@Getter
@Setter
public class TokenValidFilterConfig {
    private List<String> url;
}
