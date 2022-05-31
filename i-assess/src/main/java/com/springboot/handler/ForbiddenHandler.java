package com.springboot.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ForbiddenHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest req,
                       HttpServletResponse res,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

    	
    	JSONObject jsonObj = new JSONObject();
    	try {
		jsonObj.put("timestamp", System.currentTimeMillis());
		jsonObj.put("status", "403");
    	jsonObj.put("message", "Access is denied to you");
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        res.setContentType("application/json;charset=UTF-8");
        res.setStatus(403);
        res.getWriter().write(mapper.writeValueAsString(jsonObj));
    	}catch(JSONException exception) {
    		exception.printStackTrace();
    	}
    }
}