package com.heart.spiderman.controller;

import com.heart.spiderman.model.Answer;
import com.heart.spiderman.model.Spider;
import com.heart.spiderman.utils.FileDownloadUtils;
import com.heart.spiderman.utils.HttpUtils;
import com.heart.spiderman.utils.URLParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @GetMapping("/index")
    public ModelAndView spiderManPage() {
        return new ModelAndView("index");
    }

    /**
     * 接收前端传入的问题ID 启动spider获取该问题下所有答案内容
     *
     * @param questionId
     */
    @RequestMapping(value = "/spider/{questionId}", method = RequestMethod.GET)
    @ResponseBody
    public List<String> spiderManRun(@PathVariable("questionId") String questionId) {
        logger.info("questionId = {}，开始获取图片......", questionId);
        try {
            List<Answer> answerList = HttpUtils.spiderMan(new Spider().buildSpider(questionId));//获取所有回答
            ExecutorService executorService = Executors.newFixedThreadPool(8);//创建线程池
            int totalPhoto = 0;//接收总图片数
            int totalAnonymous = 0;//接收匿名用户数
            int totalEmpty = 0;//接收无图片回答数
            List<String> urls = new ArrayList<>();//接收所有图片url
            List<Map<String, String>> answerUrlMapList = new ArrayList<>();
            String questionTitle = answerList.get(0).getQuestion().getTitle();//保存问题标题
            for (Answer answer : answerList) {//遍历所有回答，获取所有图片url集合
                String authorName = answer.getAuthor().getName();
                if ("匿名用户".equals(authorName)) {
                    totalAnonymous += 1;
                }
                List<String> urlList = URLParseUtils.doRegexMatcher(answer.getContent());
                List<String> urlListTrim = new ArrayList<>(new HashSet<>(urlList));
                if (urlListTrim != null && urlListTrim.size() > 0) {
                    totalPhoto += urlListTrim.size();
                    urls.addAll(urlListTrim);
                    for (String url : urlListTrim) {//遍历每个问题下的图片url集合，获取authorName:url键值对保存到map
                        Map<String, String> answerUrlMap = new HashMap<>();//接收authorName:url键值对
                        answerUrlMap.put("authorName", authorName);
                        answerUrlMap.put("url", url);
                        answerUrlMapList.add(answerUrlMap);
                    }
                } else {
                    totalEmpty += 1;
                }
            }
            logger.info("共{} 条回答，{} 纯文字回答，{} 匿名用户，{} 图片，开始下载......", answerList.size(), totalEmpty, totalAnonymous, totalPhoto);
            for (Map<String, String> map : answerUrlMapList) {
                String authorName = map.get("authorName");
                String url = map.get("url");
                    FileDownloadUtils fileDownloadUtils = new FileDownloadUtils(questionTitle, authorName, url);
                    executorService.execute(fileDownloadUtils);
            }
            return urls;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}
