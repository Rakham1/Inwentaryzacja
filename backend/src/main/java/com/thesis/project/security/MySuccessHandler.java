package com.thesis.project.security;

import com.thesis.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        RequestCache requestCache = new HttpSessionRequestCache();
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
//
//        if (savedRequest == null) {
//            clearAuthenticationAttributes(request);
//            return;
//        }
//        redirectStrategy.sendRedirect(request, response, "/api/login?returnto=" + request.getServletPath());

        response.getWriter().print(String.format("{\"status\":\"success\", \"username\":\"%s\", \"permission\":\"%s\", \"uid\":%d}",
                authentication.getName(), authentication.getAuthorities().toArray()[0].toString(), userService.findPersonByUsername(authentication.getName()).getId()));
    }

    public void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
