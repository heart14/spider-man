package com.heart.spiderman.config;

/**
 * @ClassName:SpiderConfig
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 11:04
 */
public class SpiderConfig {

    /**
     * 知乎以及HTTP请求相关参数
     */
    public static final String ZHIHU_API = "https://www.zhihu.com/api/v4/questions/";
    public static final String ZHIHU_API_PARAM = "/answers?include=data[*].is_normal,admin_closed_comment,reward_info,is_collapsed,annotation_action,annotation_detail,collapse_reason,is_sticky,collapsed_by,suggest_edit,comment_count,can_comment,content,editable_content,voteup_count,reshipment_settings,comment_permission,created_time,updated_time,review_info,relevant_info,question,excerpt,relationship.is_authorized,is_author,voting,is_thanked,is_nothelp;data[*].mark_infos[*].url;data[*].author.follower_count,badge[?(type=best_answerer)].topics&sort_by=default";
    public static final String ZHIHU_COOKIE = "_zap=5ed1f805-2b63-479a-b903-3f706296b0e6; d_c0=\"AFDjdowivQ-PTq-hPQO2ed7hYB14wB5R2NE=|1563170669\"; _xsrf=PWKMl8kaXIvrgxVYY7QrmUufjHL957oA; z_c0=\"2|1:0|10:1563431420|4:z_c0|92:Mi4xMlg4MUFBQUFBQUFBVU9OMmpDSzlEeVlBQUFCZ0FsVk5fRjhkWGdCNGI1VFZtdHY3MWh1azAzT0NGM3dmbnFsUGZn|25dddff9f31808dfb0e13f7ab3dd3591be1a50de9fb4562ba297a898a6b1b40b\"; tshl=; tst=r; q_c1=f6cf86fc172248e6855bec9905b64ff8|1566208795000|1563435039000; __utma=155987696.503293702.1566797655.1566797655.1566797655.1; __utmz=155987696.1566797655.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); tgw_l7_route=f2979fdd289e2265b2f12e4f4a478330";
    public static final String HTTP_HOST = "www.zhihu.com";
    public static final String HTTP_ORIGIN = "https://www.zhihu.com";
    public static final String HTTP_ACCEPT = "application/json, text/plain, */*";
    public static final String HTTP_XUDID = "ANBmjtiRPQ6PTjCmuppHS0jFRdkBc72W5nU=";
    public static final String HTTP_CONNECTION = "Keep-Alive";
    public static final String HTTP_REFERE = "https://www.zhihu.com/question/";
    public static final String HTTP_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36";
    public static final int LIMIT = 20;
    public static final int OFFSET = 0;

    /**
     * 程序中用到的正则表达式
     * 其实只会用到.jpg的
     */
    public static final String JPG_REGEX_Pattern = "https://[^\\s]*?_r.jpg";
    public static final String JPEG_REGEX_Pattern = "https://[^\\s]*?_r.jpeg";
    public static final String PNG_REGEX_Pattern = "https://[^\\s]*?_r.png";
    public static final String BMP_REGEX_Pattern = "https://[^\\s]*?_r.bmp";
    public static final String GIF_REGEX_Pattern = "https://[^\\s]*?_r.gif";

    /**
     * 图片下载基础存储路径
     */
    public static final String FILE_TARGET_PATH = "C:/Users/jayhe/Pictures/SpiderMan/";
}
