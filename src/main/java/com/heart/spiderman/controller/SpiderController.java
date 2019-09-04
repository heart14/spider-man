package com.heart.spiderman.controller;

import com.heart.spiderman.model.Spider;
import com.heart.spiderman.utils.HttpUtils;
import com.heart.spiderman.utils.HttpUtils2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName:SpiderController
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 11:04
 */
@Controller
@RequestMapping("/")
public class SpiderController {

    private static Logger logger = LoggerFactory.getLogger(SpiderController.class);

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor1;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor2;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "spider", method = RequestMethod.POST)
    public ModelAndView spiderManRun(@RequestParam("questionId") String questionId, @RequestParam(value = "mergeFile", required = true, defaultValue = "0") int mergeFile) {
        logger.info("questionId = {},mergeFile = {}, 开始获取图片......", questionId, mergeFile);
        //268395554

        int limit = 20;
        int offset = 0;
        int total = HttpUtils2.spiderMan(questionId);

        for (int i = 0; ; i++) {
            Spider spider = new Spider().buildSpider(questionId);
            spider.setLimit(limit);
            spider.setOffset(offset);
            spider.setTotal(total);
            spider.setMergeFile(mergeFile);
            threadPoolExecutor1.execute(new HttpUtils(spider, threadPoolExecutor2));

            if (total - (limit + offset) != 0) {
                if (total - (limit + offset) > 20) {
                    offset = limit + offset;
                } else {
                    int temp = limit + offset;
                    limit = total - temp;
                    offset = temp;
                }
            } else {
                logger.info("解析完成，等待下载完成....");
                break;
            }
        }
        return new ModelAndView("success");
    }
}
