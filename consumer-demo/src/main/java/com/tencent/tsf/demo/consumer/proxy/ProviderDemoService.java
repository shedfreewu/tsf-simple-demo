package com.tencent.tsf.demo.consumer.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-demo")
public interface ProviderDemoService {
    @RequestMapping(value = "/echo/{param}", method = RequestMethod.GET)
    String echo(@PathVariable("param") String param);

    @RequestMapping(value = "/echo/error/{param}", method = RequestMethod.GET)
    String echoError(@PathVariable("param") String param);

    @RequestMapping(value = "/echo/slow/{param}", method = RequestMethod.GET)
    String echoSlow(@PathVariable("param") String param);
}