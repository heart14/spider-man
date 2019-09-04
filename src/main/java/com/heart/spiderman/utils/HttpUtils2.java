package com.heart.spiderman.utils;

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

/**
 * @ClassName: HttpUtils2
 * @Description: TODO
 * @Author: jayhe
 * @Date: 2019/9/4 9:45
 * @Version: v1.0
 */
public class HttpUtils2 {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static int spiderMan(String questionId) {
        Spider spider = new Spider().buildSpider(questionId);
        spider.setLimit(20);
        spider.setOffset(0);

        int total = 0;
        try {
            logger.info("Search " + spider.getOffset() + "~" + (spider.getOffset() + spider.getLimit()) + " answers, please wait...");

            ArrayList<Answer> answerList = new ArrayList<>();
            String result = "";
            StringBuffer responseResult = new StringBuffer();
            BufferedReader bufferedReader = null;
            String url = spider.getUrl() + "&limit=" + spider.getLimit() + "&offset=" + spider.getOffset();
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Referer", spider.getReferer());
            connection.setRequestProperty("origin", spider.getOrigin());
            connection.setRequestProperty("x-udid", spider.getX_udid());
            connection.setRequestProperty("Cookie", spider.getCookie());
            connection.setRequestProperty("accept", spider.getAccept());
            connection.setRequestProperty("connection", spider.getConnection());
            connection.setRequestProperty("Host", spider.getHost());
            connection.setRequestProperty("user-agent", spider.getUser_agent());
            connection.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                responseResult.append(line);
            }
            result = responseResult.toString();
            JSONObject resultObject = JSONObject.parseObject(result);
            String paging = resultObject.get("paging").toString();
            JSONObject page = JSONObject.parseObject(paging);
            total = (int) page.get("totals");
        } catch (IOException e) {
            logger.error("获取答案总数出错 :{}", e.getMessage());
        }
        logger.info("答案总数 :{}", total);
        return total;
    }
}
