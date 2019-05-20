package com.heart.spiderman.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heart.spiderman.model.Answer;
import com.heart.spiderman.model.Spider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:HttpUtils
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 11:05
 */
public class HttpUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * http请求访问知乎API 获取问题ID下的所有答案
     * @param spider
     * @return
     * @throws Exception
     */
    public static List<Answer> spiderMan(Spider spider) throws Exception {

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
        String paging = resultObject.get("paging").toString();
        JSONObject page = JSONObject.parseObject(paging);
        int total = spider.getTotal() == (int) page.get("totals") ? spider.getTotal() : (int) page.get("totals");
        int limit = spider.getLimit();
        int offset = spider.getOffset();
        if (total - (limit + offset) != 0) {
            if (total - (limit + offset) > 20) {
                spider.setOffset(limit + offset);
            } else {
                spider.setLimit(total - (limit + offset));
                spider.setOffset(limit + offset);
            }
            answerList.addAll(spiderMan(spider));
        }
        return answerList;
    }
}
