package com.heart.spiderman.utils;

import com.heart.spiderman.config.SpiderConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
    private String url;

    public FileDownloadUtils() {
    }

    public FileDownloadUtils(String questionTitle, String authorName, String url) {
        this.questionTitle = questionTitle;
        this.authorName = authorName;
        this.url = url;
    }

    @Override
    public void run() {

        String filePath = SpiderConfig.FILE_TARGET_PATH + this.questionTitle;//构造图片保存文件夹，以问题标题为名
        File file = new File(filePath);
        if (!file.exists()) {//文件夹不存在则创建文件夹
            file.mkdirs();
        }

        String photoPath = filePath + "/" + this.authorName;//构造图片保存文件夹，以作者昵称为名
        File photoDir = new File(photoPath);
        if (!photoDir.exists()) {//文件夹不存在则创建文件夹
            photoDir.mkdirs();
        }
        File photo = new File(photoPath + "/" + URLParseUtils.doFetchUID(this.url));//构造图片文件
        if (photo.exists()) {//如果图片文件已存在，则忽略
            logger.info("[{}][{}][{}] 图片已存在", Thread.currentThread().getName(), this.authorName, URLParseUtils.doFetchUID(this.url));
            return;
        }

        BufferedOutputStream bufferedOutputStream = null;
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(25 * 1000);
            connection.setReadTimeout(25 * 1000);
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                logger.info("[{}][{}][{}] 下载失败，请求错误", Thread.currentThread().getName(), this.authorName, URLParseUtils.doFetchUID(this.url));
                return;
            }
            logger.info("[{}][{}][{}] 下载完成", Thread.currentThread().getName(), this.authorName, URLParseUtils.doFetchUID(this.url));
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
