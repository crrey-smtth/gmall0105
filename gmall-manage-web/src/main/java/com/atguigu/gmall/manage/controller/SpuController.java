package com.atguigu.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
public class SpuController {


    @Reference
    SpuService spuService;


    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos= spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile multipartFile){
        //将图片或者音视频上传到分布式的文件存储服务器

        //将图片的存储路径返回给页面
        String imgUrl = "";
        return  imgUrl;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo  pmsProductInfo){

       // List<PmsProductInfo> pmsProductInfos= spuService.spuList(catalog3Id);
        return "success";
    }
}
