package com.apps.util;

import com.apps.dto.ClientInfoDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ClientInfoUtil {

    private ClientInfoUtil() {}

    public static ClientInfoDTO build(HttpServletRequest request) {

        return ClientInfoDTO.builder()
                .ipAddress(getClientIp(request))
                .host(request.getRemoteHost())
                .port(request.getRemotePort())
                .httpMethod(request.getMethod())
                .requestUri(request.getRequestURI())
                .queryString(request.getQueryString())
                .userAgent(request.getHeader("User-Agent"))
                .referer(request.getHeader("Referer"))
                .headers(getHeaders(request))
                .build();
    }

    private static String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Forwarded-For");
        if (xff != null && !xff.isBlank()) {
            return xff.split(",")[0];
        }
        return request.getRemoteAddr();
    }

    private static Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            map.put(header, request.getHeader(header));
        }
        return map;
    }
}
