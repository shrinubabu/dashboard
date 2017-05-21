package com.tcs.iou.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Shrinubabu on 5/20/2017.
 */

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    Logger logger = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        logger.info("CustomLogoutSuccessHandler Invoked");
        setAlwaysUseDefaultTargetUrl(true);
        setDefaultTargetUrl("/login");
        super.onLogoutSuccess(request, response, authentication);
    }

}