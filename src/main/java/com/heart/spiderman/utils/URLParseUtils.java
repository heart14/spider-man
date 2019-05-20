package com.heart.spiderman.utils;

import com.heart.spiderman.config.SpiderConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName:URLParseUtils
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 13:31
 */
public class URLParseUtils {

    /**
     * 从回答正文中根据正则匹配提取图片下载链接
     */
    public static List<String> doRegexMatcher(String srcString) {

        Pattern jpgPattern = Pattern.compile(SpiderConfig.JPG_REGEX_Pattern);
        Pattern jpegPattern = Pattern.compile(SpiderConfig.JPEG_REGEX_Pattern);
        Pattern pngPattern = Pattern.compile(SpiderConfig.PNG_REGEX_Pattern);
        Pattern bmpPattern = Pattern.compile(SpiderConfig.BMP_REGEX_Pattern);
        Pattern gifPattern = Pattern.compile(SpiderConfig.GIF_REGEX_Pattern);

        Matcher jpgMatcher = jpgPattern.matcher(srcString);
        Matcher jpegMatcher = jpegPattern.matcher(srcString);
        Matcher pngMatcher = pngPattern.matcher(srcString);
        Matcher bmpMatcher = bmpPattern.matcher(srcString);
        Matcher gifMatcher = gifPattern.matcher(srcString);

        List<String> urlList = new ArrayList<>();
        while (jpgMatcher.find()) {
            urlList.add(jpgMatcher.group());
        }
        while (jpegMatcher.find()) {
            urlList.add(jpegMatcher.group());
        }
        while (pngMatcher.find()) {
            urlList.add(pngMatcher.group());
        }
        while (bmpMatcher.find()) {
            urlList.add(bmpMatcher.group());
        }
        while (gifMatcher.find()) {
            urlList.add(gifMatcher.group());
        }

        return urlList;
    }

    /**
     * 从下载链接中截取一段作为文件名
     *
     * @param url
     * @return
     */
    public static String doFetchUID(String url) {
        return url.split("zhimg.com/")[1].replaceAll("/", "").substring(0, 12) + ".jpg";
    }
}
