package com.demo.Logging.filter;

import com.demo.Logging.config.LogContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class LogContextInterceptor implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogContextInterceptor.class);

    private final Environment environment;

    @Autowired
    public LogContextInterceptor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String clientIp = getClientIp(httpServletRequest.getHeader("X-Forwarded-For"));
            if (clientIp == null) {
                clientIp = httpServletRequest.getRemoteAddr();
            }
            String traceId = httpServletRequest.getHeader("X-TRACE-ID");
            LogContext.updateRequestContext(logRequest(httpServletRequest), clientIp,
                    httpServletRequest.getHeader("callerId"), traceId);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            logger.error("Exception while setting request context for incoming request", ex);
        } finally {
            LogContext.clearLogContext();
        }
    }

    public static String getClientIp(String header) {
        String clientIp = null;
        if (null != header) {
            String[] xForwardedForList = header.split(",");
            clientIp = xForwardedForList[0].trim();
        }
        return clientIp;
    }

    private String logRequest(HttpServletRequest httpServletRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        if (null != httpServletRequest) {
            stringBuilder.append(httpServletRequest.getMethod()).append(' ');
            stringBuilder.append(httpServletRequest.getServerName()).append(' ');
            stringBuilder.append(httpServletRequest.getRequestURI()).append(' ');
            stringBuilder.append(httpServletRequest.getQueryString()).append(' ');
            stringBuilder.append(UUID.randomUUID());
        }
        return stringBuilder.toString();
    }

}
