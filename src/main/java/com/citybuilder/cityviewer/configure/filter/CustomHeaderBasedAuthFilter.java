package com.citybuilder.cityviewer.configure.filter;


import com.citybuilder.cityviewer.configure.security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Custome header base auth filter to authenticate client side user
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Service
public class CustomHeaderBasedAuthFilter extends GenericFilterBean {

    @Autowired
    AppUserDetailsService userService;

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // get pass login username through reuest header
        String username = ((HttpServletRequest) request).getHeader("x-username");
        if (username != null) {
            // Set authorities and credentials
            UserDetails detail = userService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(detail, null, detail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        chain.doFilter(request, response);
    }
}