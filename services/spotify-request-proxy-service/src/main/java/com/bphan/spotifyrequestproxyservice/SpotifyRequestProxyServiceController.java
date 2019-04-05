package com.bphan.spotifyrequestproxyservice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyRequestProxyServiceController {

    @RequestMapping(value = "/requestProxy/", method = RequestMethod.POST)
    public void proxySpotifyRequest(@RequestBody Map<String, Object> requestBody, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request_api_endpoint: " + requestBody.get("request_api_endpoint"));
        System.out.println("client_session_id: " + requestBody.get("client_session_id"));
    }

}