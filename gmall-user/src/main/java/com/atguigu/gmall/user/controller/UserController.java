package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController
{

    @Autowired
    UserService userService;


    @RequestMapping("index")
    @ResponseBody
    public  String index(){


        return "hello user";
    }


    @RequestMapping("getAllUser")
    @ResponseBody
    public  List<UmsMember> getAllUser(){

       List<UmsMember>  UmsMembers = userService.getAllUser();
        return UmsMembers;
    }



    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public  List<UmsMemberReceiveAddress> getReceiveAddressByMemberId( String memberId){

        List<UmsMemberReceiveAddress>  UmsMemberReceiveAddresss = userService.getReceiveAddressByMemberId(memberId);
        return UmsMemberReceiveAddresss;
    }
}
