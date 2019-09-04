package com.heart.spiderman.model;

import com.heart.spiderman.config.SpiderConfig;

/**
 * @ClassName:Spider
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 11:02
 */
public class Spider {

    private String url;
    private String referer;
    private String origin;
    private String x_udid;
    private String accept;
    private String connection;
    private String host;
    private String cookie;
    private String user_agent;
    private int total;
    private int limit;
    private int offset;
    private int mergeFile;

    public Spider() {
    }

    public Spider(String url, String referer, String origin, String x_udid, String accept, String connection, String host, String cookie, String user_agent, int total, int limit, int offset, int mergeFile) {
        this.url = url;
        this.referer = referer;
        this.origin = origin;
        this.x_udid = x_udid;
        this.accept = accept;
        this.connection = connection;
        this.host = host;
        this.cookie = cookie;
        this.user_agent = user_agent;
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.mergeFile = mergeFile;
    }

    public String getUrl() {
        return url;
    }

    public Spider setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getReferer() {
        return referer;
    }

    public Spider setReferer(String referer) {
        this.referer = referer;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public Spider setOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public String getX_udid() {
        return x_udid;
    }

    public Spider setX_udid(String x_udid) {
        this.x_udid = x_udid;
        return this;
    }

    public String getAccept() {
        return accept;
    }

    public Spider setAccept(String accept) {
        this.accept = accept;
        return this;
    }

    public String getConnection() {
        return connection;
    }

    public Spider setConnection(String connection) {
        this.connection = connection;
        return this;
    }

    public String getHost() {
        return host;
    }

    public Spider setHost(String host) {
        this.host = host;
        return this;
    }

    public String getCookie() {
        return cookie;
    }

    public Spider setCookie(String cookie) {
        this.cookie = cookie;
        return this;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public Spider setUser_agent(String user_agent) {
        this.user_agent = user_agent;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public Spider setTotal(int total) {
        this.total = total;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public Spider setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public Spider setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public int getMergeFile() {
        return mergeFile;
    }

    public Spider setMergeFile(int mergeFile) {
        this.mergeFile = mergeFile;
        return this;
    }

    public Spider buildSpider(String questionId) {
        this.setUrl(SpiderConfig.ZHIHU_API + questionId + SpiderConfig.ZHIHU_API_PARAM);
        this.setCookie(SpiderConfig.ZHIHU_COOKIE);
        this.setHost(SpiderConfig.HTTP_HOST);
        this.setAccept(SpiderConfig.HTTP_ACCEPT);
        this.setConnection(SpiderConfig.HTTP_CONNECTION);
        this.setOrigin(SpiderConfig.HTTP_ORIGIN);
        this.setReferer(SpiderConfig.HTTP_REFERE + questionId);
        this.setX_udid(SpiderConfig.HTTP_XUDID);
        this.setUser_agent(SpiderConfig.HTTP_USER_AGENT);
        return this;
    }
}
