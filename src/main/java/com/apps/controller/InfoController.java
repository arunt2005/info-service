package com.apps.controller;

import com.apps.dto.ClientInfoDTO;
import com.apps.util.ClientInfoUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping
    public ResponseEntity<?> msg() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("info service application.", headers, HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<ClientInfoDTO> getClientInfo(HttpServletRequest request) {
        ClientInfoDTO clientInfo = ClientInfoUtil.build(request);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(clientInfo, headers, HttpStatus.OK);
    }

}
