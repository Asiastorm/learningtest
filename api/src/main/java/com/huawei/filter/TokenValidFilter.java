package com.huawei.filter;

import com.google.common.base.Preconditions;
import com.huawei.Dao.UserInfoDo;
import com.huawei.config.TokenValidFilterConfig;
import com.huawei.exception.BusinessException;
import com.huawei.service.RedisService;
import com.huawei.utils.RandomUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;

@Order(2)
@Component
public class TokenValidFilter implements Filter {
    private static final String TOKEN_KEY = "auth-token";

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenValidFilterConfig tokenValidFilterConfig;

    public TokenValidFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (!tokenValidFilterConfig.getUrl().contains(req.getRequestURI())) {
            String token = req.getHeader(TOKEN_KEY);
            if (!isValidToken(TOKEN_KEY)) {
                throw new BusinessException();
            }

        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isValidToken(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "token is empty");
        UserInfoDo userInfoDo = (UserInfoDo) redisService.get(token);
        return userInfoDo != null;
    }
}
