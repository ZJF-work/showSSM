//package com.hz.ssm.controller;
//
//import com.hz.ssm.service.IndexService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/user")
//public class IndexController {
//
//    @RequestMapping("/show")
//    public String showUser(){
//        return "/user";
//    }
//
//    @Autowired
//    private IndexService indexService;
//
//    @RequestMapping("/show")
//    public String showIndex(Model model){
//
//        String name = indexService.query();
//
//        model.addAttribute("name",name);
//
//        return "index";
//    }
//}
