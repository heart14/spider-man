package com.heart.spiderman.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heart.spiderman.model.Answer;
import com.heart.spiderman.model.Spider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: HttpUtils
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 11:05
 */
public class HttpUtils implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private Spider spider;

    private ThreadPoolExecutor threadPoolExecutor2;

    public HttpUtils() {
    }

    public HttpUtils(Spider spider, ThreadPoolExecutor threadPoolExecutor2) {
        this.spider = spider;
        this.threadPoolExecutor2 = threadPoolExecutor2;
    }

    @Override
    public void run() {
        try {
            logger.info("Search " + this.spider.getOffset() + "~" + (this.spider.getOffset() + this.spider.getLimit()) + " answers, please wait...");

            ArrayList<Answer> answerList = new ArrayList<>();
            String result = "";
            StringBuffer responseResult = new StringBuffer();
            BufferedReader bufferedReader = null;
            String url = this.spider.getUrl() + "&limit=" + this.spider.getLimit() + "&offset=" + this.spider.getOffset();
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Referer", this.spider.getReferer());
            connection.setRequestProperty("origin", this.spider.getOrigin());
            connection.setRequestProperty("x-udid", this.spider.getX_udid());
            connection.setRequestProperty("Cookie", this.spider.getCookie());
            connection.setRequestProperty("accept", this.spider.getAccept());
            connection.setRequestProperty("connection", this.spider.getConnection());
            connection.setRequestProperty("Host", this.spider.getHost());
            connection.setRequestProperty("user-agent", this.spider.getUser_agent());
            connection.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseResult.append(line);
            }
            result = responseResult.toString();
            JSONObject resultObject = JSONObject.parseObject(result);
            String resultData = resultObject.get("data").toString();
            JSONArray dataArray = JSONArray.parseArray(resultData);
            for (int i = 0; i < dataArray.size(); i++) {
                Answer answer = JSON.parseObject(dataArray.get(i).toString(), Answer.class);
                Answer.Question question = JSON.parseObject(JSONObject.parseObject(dataArray.get(i).toString()).get("question").toString(), Answer.Question.class);
                answer.setQuestion(question);
                Answer.Author author = JSON.parseObject(JSONObject.parseObject(dataArray.get(i).toString()).get("author").toString(), Answer.Author.class);
                answer.setAuthor(author);
                answerList.add(answer);
            }
            for (Answer answer : answerList) {
                //保存问题标题
                String questionTitle = answer.getQuestion().getTitle();
                //保存作者昵称
                String authorName = answer.getAuthor().getName();
                //获取答案中图片集合
                List<String> urlList = URLParseUtils.doRegexMatcher(answer.getContent());
                //去重
                List<String> urlListTrim = new ArrayList<>(new HashSet<>(urlList));
                //遍历图片url集合，进行下载
                if (urlListTrim.size() > 0) {
                    for (String s : urlListTrim) {
                        if (spider.getMergeFile() == 0) {
                            FileDownloadUtils fileDownloadThread = new FileDownloadUtils(questionTitle, authorName, s);
                            threadPoolExecutor2.execute(fileDownloadThread);
                        } else if (spider.getMergeFile() == 1) {
                            FileDownloadUtils2 fileDownloadThread = new FileDownloadUtils2(questionTitle, authorName, s);
                            threadPoolExecutor2.execute(fileDownloadThread);
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error("获取答案 {}~{} 出错 :{}", this.spider.getOffset(), this.spider.getOffset() + this.spider.getLimit(), e.getMessage());
        }
    }
}
