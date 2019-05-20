package com.heart.spiderman.controller;

import com.heart.spiderman.model.Answer;
import com.heart.spiderman.model.Spider;
import com.heart.spiderman.utils.FileDownloadUtils;
import com.heart.spiderman.utils.HttpUtils;
import com.heart.spiderman.utils.URLParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
     * @param questionId
     */
    @RequestMapping(value = "/spider/{questionId}", method = RequestMethod.POST)
    public void spiderManRun(@PathVariable("questionId") String questionId) {
        logger.info("questionId = {}", questionId);
        try {
            List<Answer> answerList = HttpUtils.spiderMan(new Spider().buildSpider(questionId));

            for (Answer answer : answerList) {
                List<String> urlList = URLParseUtils.doRegexMatcher(answer.getContent());
                if (urlList != null && urlList.size() > 0) {
                    List<String> urls = new ArrayList<>(new HashSet<>(urlList));
                    FileDownloadUtils fileDownloadUtils = new FileDownloadUtils(answer.getQuestion().getTitle(), answer.getAuthor().getName(), urls);
                    Thread thread = new Thread(fileDownloadUtils);
                    thread.start();
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }


    }

}
