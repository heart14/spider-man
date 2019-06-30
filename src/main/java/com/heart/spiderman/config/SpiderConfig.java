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
    public static final String ZHIHU_COOKIE = "_zap=1d10a086-23f6-44c5-b191-3e8f3e1183c2; d_c0=\"ADDkdxUBGg-PTt0pJdZ9XgJ7heOpOrVZyp0=|1552223152\"; __gads=ID=9b714a10c40bbf30:T=1556032272:S=ALNI_MbJ5hCcq-OSitpnGmw-3860cnZxug; _xsrf=dlJZ52SNWVtDp0lZfBu7AkDIDWmmlnEg; capsion_ticket=\"2|1:0|10:1556121554|14:capsion_ticket|44:ZjZjMGUyNzUwM2FmNGY2MWEzOTkwMmZmMGRmNDc1OTI=|bd38703d8cd754c76b65ccd62ff5805d45a624dcf9fa6ebc22e3869d3e1bb3e8\"; z_c0=\"2|1:0|10:1556121556|4:z_c0|92:Mi4xMlg4MUFBQUFBQUFBTU9SM0ZRRWFEeVlBQUFCZ0FsVk4xTld0WFFET1JLSlpNdV91a2xkTEVVdFdxNF83allsMUJ3|adbc3dcfc86246b582966e1960e7112127f6c3157626765f184e32f11ecdd905\"; q_c1=9693076a86e440e18ea6c4c81da0ea6b|1558021846000|1552223153000; tgw_l7_route=a37704a413efa26cf3f23813004f1a3b; tst=r";
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
    public static final String FILE_TARGET_PATH = "C:/Users/lwf14/Pictures/SpiderMan/";
}
