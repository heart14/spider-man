package com.heart.spiderman.utils;

import com.heart.spiderman.config.SpiderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @ClassName:FileDownloadUtils
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 13:42
 */
public class FileDownloadUtils implements Runnable {

    public static final Logger logger = LoggerFactory.getLogger(FileDownloadUtils.class);

    private String questionTitle;
    private String authorName;
    private List<String> urls;

    public FileDownloadUtils() {
    }

    public FileDownloadUtils(String questionTitle, String authorName, List<String> urls) {
        this.questionTitle = questionTitle;
        this.authorName = authorName;
        this.urls = urls;
    }

    @Override
    public void run() {
        String filePath = SpiderConfig.FILE_TARGET_PATH + questionTitle;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (String urlStr : urls) {

            File photo = new File(filePath + "/" + authorName + "_" + URLParseUtils.doFetchUID(urlStr));
            if (photo.exists()) {
                continue;
            }

            BufferedOutputStream bufferedOutputStream = null;
            try {
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5 * 1000);
                connection.setReadTimeout(5 * 1000);
                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    logger.info("[" + authorName + "]  \t{}", "下载失败，请求错误" + URLParseUtils.doFetchUID(urlStr));
                    continue;
                }
                logger.info("[" + authorName + "]  \t{}", "正在下载" + URLParseUtils.doFetchUID(urlStr));
                InputStream inputStream = connection.getInputStream();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(photo));
                int count;
                byte[] bytes = new byte[2048];
                while ((count = inputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, count);
                }
                bufferedOutputStream.flush();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
