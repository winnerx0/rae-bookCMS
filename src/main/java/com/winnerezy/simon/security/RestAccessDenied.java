package com.winnerezy.simon.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winnerezy.simon.responses.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestAccessDenied implements AccessDeniedHandler {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        response.setContentType("application/json");

        ErrorResponse errorResponse = new ErrorResponse("Permission denied to access");

        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
