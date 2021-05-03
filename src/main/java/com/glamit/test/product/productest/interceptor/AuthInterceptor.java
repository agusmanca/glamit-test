package com.glamit.test.product.productest.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Objects;

public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authHeader = request.getHeader("Authorization");

        if(!Objects.isNull(authHeader)) {
            int idx = authHeader.indexOf("Bearer ") + "Bearer ".length();
            String sign = new String(Base64.getDecoder().decode(authHeader.substring(idx).trim()));

            log.info("La firma de autorizacion es: " + sign);

            return true;
        } else {
            response.sendError(401, "Unauthorized");
            return false;
        }
    }
}
