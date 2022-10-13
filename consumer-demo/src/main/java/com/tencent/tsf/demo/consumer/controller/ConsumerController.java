package com.tencent.tsf.demo.consumer.controller;

import com.tencent.tsf.demo.consumer.proxy.ProviderDemoService;
import com.tencent.tsf.demo.consumer.proxy.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AsyncRestTemplate asyncRestTemplate;

    @Autowired
    private ProviderDemoService providerDemoService;

    @Autowired
    private ProviderService providerService;


    @RequestMapping(value = "/echo-rest/{param}", method = RequestMethod.GET)
    public String restProvider(@PathVariable String param) {
        LOG.info("echo-rest: http://provider-demo/echo/, param: " + param);
        return restTemplate.getForObject("http://provider-demo/echo/" + param, String.class);
    }

    @RequestMapping(value = "/echo-async-rest/{param}", method = RequestMethod.GET)
    public String asyncRestProvider(@PathVariable String param) throws Exception {
        LOG.info("echo-async-rest: http://provider-demo/echo/, param: " + param);
        ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate
                .getForEntity("http://provider-demo/echo/" + param, String.class);
        return future.get().getBody();
    }

    @RequestMapping(value = "/echo-feign/{param}", method = RequestMethod.GET)
    public String feignProvider(@PathVariable String param) {
        LOG.info(String.format("echo-feign: providerDemoService.echo(%s)", param));
        return providerDemoService.echo(param);
    }

    @RequestMapping(value = "/echo-feign/error/{param}", method = RequestMethod.GET)
    public String feignErrorProvider(@PathVariable String param) {
        LOG.info(String.format("echo-feign(error): providerDemoService.echoError(%s)", param));
        return providerDemoService.echoError(param);
    }

    @RequestMapping(value = "/echo-feign/slow/{param}", method = RequestMethod.GET)
    public String feignSlowProvider(@PathVariable String param) {
        LOG.info(String.format("echo-feign(slow): providerDemoService.echoSlow(%s)", param));
        return providerDemoService.echoSlow(param);
    }

    @RequestMapping(value = "/echo-feign-url/{param}", method = RequestMethod.GET)
    public String feignUrlProvider(@PathVariable String param) {
        LOG.info(String.format("echo-feign-url: providerDemoService.echoError(%s)", param));
        return providerService.echo(param);
    }
}