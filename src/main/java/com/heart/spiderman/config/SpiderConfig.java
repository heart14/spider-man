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
    public static final String ZHIHU_COOKIE = "_zap=8e6ff4fe-12e7-4b4c-a5b7-9112cdd5ce8c; _xsrf=zwRIfedfMoA2A4YLFPxn5O9i3gKxFevS; d_c0=\"AMCj6cYYGw-PToPCZkP5bFoOEuKASQfVtvE=|1552296472\"; z_c0=\"2|1:0|10:1552296478|4:z_c0|92:Mi4xMlg4MUFBQUFBQUFBd0tQcHhoZ2JEeVlBQUFCZ0FsVk5Ibmh6WFFBbGlPYzBmSFFCLVk2b1hGb1VINTU4Y3hlakRn|6de289a27430536214e21f8e285f8a0aab410e81cce472f84d5f4c52f89a791f\"; __utmv=51854390.100-1|2=registration_date=20140209=1^3=entry_date=20140209=1; __utmz=51854390.1553496653.2.2.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/question/58116374; q_c1=bb487bc8800946949ea234c803bc2245|1555033486000|1552297706000; __utma=51854390.1365540508.1552297708.1553496653.1556075904.3; tst=r; tgw_l7_route=4860b599c6644634a0abcd4d10d37251";
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
