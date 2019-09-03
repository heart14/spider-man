package com.heart.spiderman.controller;

import com.alibaba.fastjson.JSONObject;
import com.heart.spiderman.model.Spider;
import com.heart.spiderman.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ModelAndView spiderManRun(@RequestParam("questionId") String questionId, @RequestParam("answerNum") int answerNum, @RequestParam(value = "mergeFile", required = true, defaultValue = "0") int mergeFile) {
        logger.info("questionId = {},answerNum = {},mergeFile = {}, 开始获取图片......", questionId, answerNum, mergeFile);
        //268395554

        int limit = 20;
        int offset = 0;
        int total = answerNum;

        for (int i = 0; ; i++) {
            Spider spider = new Spider().buildSpider(questionId);
            spider.setLimit(limit);
            spider.setOffset(offset);
            spider.setTotal(answerNum);
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

    /**
     * SpiderManRun
     *
     * @param questionId
     */
//    @RequestMapping(value = "/spider/{questionId}", method = RequestMethod.GET)
//    @ResponseBody
//    public String spiderManRun(@PathVariable("questionId") String questionId) {
//        logger.info("questionId = {}，开始获取图片......", questionId);
//        JSONObject jsonObject = new JSONObject(1);
//        try {
//            //获取所有回答
//            List<Answer> answerList = HttpUtils.spiderMan(new Spider().buildSpider(questionId));
//            //接收总图片数
//            int totalPhoto = 0;
//            //接收匿名用户数
//            int totalAnonymous = 0;
//            //接收无图片回答数
//            int totalEmpty = 0;
//            //接收所有图片url
//            List<String> urls = new ArrayList<>();
//            List<Map<String, String>> answerUrlMapList = new ArrayList<>();
//
//
//            //保存问题标题
//            String questionTitle = answerList.get(0).getQuestion().getTitle();
//            //遍历所有回答，获取所有图片url集合
//            for (Answer answer : answerList) {
//                String authorName = answer.getAuthor().getName();
//                if ("匿名用户".equals(authorName)) {
//                    totalAnonymous += 1;
//                }
//                List<String> urlList = URLParseUtils.doRegexMatcher(answer.getContent());
//                List<String> urlListTrim = new ArrayList<>(new HashSet<>(urlList));
//                if (urlListTrim != null && urlListTrim.size() > 0) {
//                    totalPhoto += urlListTrim.size();
//                    urls.addAll(urlListTrim);
//                    //遍历每个问题下的图片url集合，获取authorName:url键值对保存到map
//                    for (String url : urlListTrim) {
//                        //接收authorName:url键值对
//                        Map<String, String> answerUrlMap = new HashMap<>();
//                        answerUrlMap.put("authorName", authorName);
//                        answerUrlMap.put("url", url);
//
//                        answerUrlMapList.add(answerUrlMap);
//                    }
//                } else {
//                    totalEmpty += 1;
//                }
//            }
//            logger.info("共{} 条回答，{} 纯文字回答，{} 匿名用户，{} 图片，开始下载......", answerList.size(), totalEmpty, totalAnonymous, totalPhoto);
//            for (Map<String, String> map : answerUrlMapList) {
//                String authorName = map.get("authorName");
//                String url = map.get("url");
//                FileDownloadUtils fileDownloadUtils = new FileDownloadUtils(questionTitle, authorName, url);
//                threadPoolExecutor.execute(fileDownloadUtils);
//            }
//            jsonObject.put("src", urls);
//            return jsonObject.toJSONString();
//        } catch (Exception e) {
//            logger.error("zhihu图片解析失败 :{}", e.getMessage());
//        }
//        jsonObject.put("src", "[]");
//        return jsonObject.toJSONString();
//    }

}
