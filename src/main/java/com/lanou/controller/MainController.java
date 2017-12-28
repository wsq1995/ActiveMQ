package com.lanou.controller;

import com.lanou.MQService.ConsumerService;
import com.lanou.MQService.PrducerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/12/27.
 */
@Controller
public class MainController {

    @Resource
    private ConsumerService consumerService;

    @Resource
    private PrducerService prducerService;

    @RequestMapping(value = "/home")
    public String homepage(){
        return "home";
    }

//    提供给表单使用
    @RequestMapping(value = "/send")
    public String sendMsg(@RequestParam("msg") String message){
        prducerService.sendMessage(message);

        System.out.println("发送消息到MQ");

        return "home";
    }

    @RequestMapping("/receive")
    public ModelAndView receiveMsg(){

        ModelAndView mv = new ModelAndView();

        mv.setViewName("consumer");

        mv.addObject("msg",consumerService.receiveMsg());

        return mv;
    }

//    消息生成者页面
    @RequestMapping("/producer")
    public String prducerPage(){
        return "producer";
    }






}
