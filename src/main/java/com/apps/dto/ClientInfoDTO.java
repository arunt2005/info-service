package com.apps.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ClientInfoDTO {

    private String ipAddress;
    private String host;
    private Integer port;

    private String httpMethod;
    private String requestUri;
    private String queryString;

    private String userAgent;
    private String referer;

    private Map<String, String> headers;
}
