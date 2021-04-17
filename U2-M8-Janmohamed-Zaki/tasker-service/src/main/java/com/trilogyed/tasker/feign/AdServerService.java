package com.trilogyed.tasker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "adserver-service")
public interface AdServerService {
    @RequestMapping(value = "/ad", method = RequestMethod.GET)
     String getAd();
}
