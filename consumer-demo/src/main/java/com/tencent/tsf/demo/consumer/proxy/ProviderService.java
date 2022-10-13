package com.tencent.tsf.demo.consumer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider", url = "http://127.0.0.1:18081", fallback = FeignClientFallback.class)
public interface ProviderService {
    @RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
    String echo(@PathVariable("param") String param);
}

@Component
class FeignClientFallback implements ProviderService {
    @Override
    public String echo(String param) {
        return "tsf-fault-tolerance-" + param;
    }
}