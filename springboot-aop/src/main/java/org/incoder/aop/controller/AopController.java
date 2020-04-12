package org.incoder.aop.controller;

import org.incoder.aop.annotation.Log;
import org.incoder.aop.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Jerry xu
 * @date : 2019/10/29  13:13
 */
@RestController
@RequestMapping(value = "/aop")
public class AopController {

    /**
     * 简单示例
     */
    @RequestMapping("/aop")
    @Log(value = "请求了aopDemo方法")
    public String aopDemo(String hello) {
        return "请求参数: " + hello;
    }

    /**
     * 不拦截日志示例
     */
    @PostMapping("/notaop")
    @Log(ignore = true)
    public String notAopDemo(String hello) {
        return "此方法不记录日志，请求参数：" + hello;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/test")
    public Result test(@RequestParam boolean throwException) throws Exception {
        // case 1
        if (throwException) {
            System.out.println("throw an exception");
            throw new Exception("mock a server exception");
        }

        // case 2
        System.out.println("test OK");
        return new Result() {{
            this.setId(111);
            this.setName("mock a Result");
        }};
    }

}
