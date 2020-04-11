package com.atguigu.gmall.manage;

import cn.hutool.cron.CronUtil;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GmallManageWebApplicationTests {

    @Test
    void contextLoads() throws IOException, MyException {

        String tracker = GmallManageWebApplicationTests.class.getResource("tracker.conf").getPath();//获取配置文件的路径
        ClientGlobal.init(tracker);
        TrackerClient trackerClient = new TrackerClient();
        //获的一个trackerServer的实例
        TrackerServer trackerServer =trackerClient.getTrackerServer();
        //通过tracker获得一个Storage连接客户端
        new CronUtil()
        StorageClient storageClient =new  StorageClient(trackerServer,null);
        String[]  uploadInfos = storageClient.upload_file("F:/谷粒商城源代码/谷粒商城项目/测试图片/1.jpg","jpg",null);
        for (String uploadInfo : uploadInfos){
            System.out.println(uploadInfo);
        }
    }

}
