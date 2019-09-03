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
    public static final String ZHIHU_COOKIE = "_zap=234fef7a-606c-406a-ad49-aaa96b3a53ca; d_c0=\"ACDiD0_Fvg-PTrgR2_z8zkRDPV3lsUjLAII=|1563280445\"; z_c0=\"2|1:0|10:1563564904|4:z_c0|92:Mi4xMlg4MUFBQUFBQUFBSU9JUFQ4Vy1EeVlBQUFCZ0FsVk5hR2tmWGdCZkljdWo2WXRCVFBIajZTYWhBLVd1WVYwQVpR|d74c6a5061f296f84fb63614db1dafb0daa5e52ad86ec81b7fd77e3488b970d0\"; tst=r; q_c1=6e1823c738fa434b81d5035ab859e151|1566030705000|1566030705000; tgw_l7_route=4860b599c6644634a0abcd4d10d37251; _xsrf=1daa0790-6217-40fc-8b99-3179380552ae";
    public static final String HTTP_HOST = "www.zhihu.com";
    public static final String HTTP_ORIGIN = "https://www.zhihu.com";
    public static final String HTTP_ACCEPT = "application/json, text/plain, */*";
    public static final String HTTP_XUDID = "ANBmjtiRPQ6PTjCmuppHS0jFRdkBc72W5nU=";
    public static final String HTTP_CONNECTION = "Keep-Alive";
    public static final String HTTP_REFERE = "https://www.zhihu.com/question/";
    public static final String HTTP_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36";
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
    public static final String FILE_TARGET_PATH = "C:/Users/lwf14/Pictures/SpiderMan/";
}
