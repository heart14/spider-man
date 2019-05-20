package com.heart.spiderman.model;

/**
 * @ClassName:Answer
 * @Description:
 * @Author: Heart
 * @Date: 2019/5/20 10:59
 */
public class Answer {
    private String id;

    private String type;

    private Question question;

    private Author author;

    private String url;

    private String thumbnail;

    private String is_collapsed;

    private String created_time;

    private String updated_time;

    private String extras;

    private String is_copyable;

    private String is_normal;

    private String voteup_count;

    private String comment_count;

    private String is_sticky;

    private String admin_closed_comment;

    private String comment_permission;

    private String can_comment;

    private String reshipment_settings;

    private String content;

    private String editable_content;

    private String excerpt;

    private String collapsed_by;

    private String collapse_reason;

    private String[] annotation_action;

    private String relevant_info;

    private String suggest_edit;

    private String reward_info;

    private String relationship;

    public String getId() {
        return id;
    }

    public Answer setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Answer setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Answer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Answer setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getIs_collapsed() {
        return is_collapsed;
    }

    public Answer setIs_collapsed(String is_collapsed) {
        this.is_collapsed = is_collapsed;
        return this;
    }

    public String getCreated_time() {
        return created_time;
    }

    public Answer setCreated_time(String created_time) {
        this.created_time = created_time;
        return this;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public Answer setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
        return this;
    }

    public String getExtras() {
        return extras;
    }

    public Answer setExtras(String extras) {
        this.extras = extras;
        return this;
    }

    public String getIs_copyable() {
        return is_copyable;
    }

    public Answer setIs_copyable(String is_copyable) {
        this.is_copyable = is_copyable;
        return this;
    }

    public String getIs_normal() {
        return is_normal;
    }

    public Answer setIs_normal(String is_normal) {
        this.is_normal = is_normal;
        return this;
    }

    public String getVoteup_count() {
        return voteup_count;
    }

    public Answer setVoteup_count(String voteup_count) {
        this.voteup_count = voteup_count;
        return this;
    }

    public String getComment_count() {
        return comment_count;
    }

    public Answer setComment_count(String comment_count) {
        this.comment_count = comment_count;
        return this;
    }

    public String getIs_sticky() {
        return is_sticky;
    }

    public Answer setIs_sticky(String is_sticky) {
        this.is_sticky = is_sticky;
        return this;
    }

    public String getAdmin_closed_comment() {
        return admin_closed_comment;
    }

    public Answer setAdmin_closed_comment(String admin_closed_comment) {
        this.admin_closed_comment = admin_closed_comment;
        return this;
    }

    public String getComment_permission() {
        return comment_permission;
    }

    public Answer setComment_permission(String comment_permission) {
        this.comment_permission = comment_permission;
        return this;
    }

    public String getCan_comment() {
        return can_comment;
    }

    public Answer setCan_comment(String can_comment) {
        this.can_comment = can_comment;
        return this;
    }

    public String getReshipment_settings() {
        return reshipment_settings;
    }

    public Answer setReshipment_settings(String reshipment_settings) {
        this.reshipment_settings = reshipment_settings;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Answer setContent(String content) {
        this.content = content;
        return this;
    }

    public String getEditable_content() {
        return editable_content;
    }

    public Answer setEditable_content(String editable_content) {
        this.editable_content = editable_content;
        return this;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public Answer setExcerpt(String excerpt) {
        this.excerpt = excerpt;
        return this;
    }

    public String getCollapsed_by() {
        return collapsed_by;
    }

    public Answer setCollapsed_by(String collapsed_by) {
        this.collapsed_by = collapsed_by;
        return this;
    }

    public String getCollapse_reason() {
        return collapse_reason;
    }

    public Answer setCollapse_reason(String collapse_reason) {
        this.collapse_reason = collapse_reason;
        return this;
    }

    public String[] getAnnotation_action() {
        return annotation_action;
    }

    public Answer setAnnotation_action(String[] annotation_action) {
        this.annotation_action = annotation_action;
        return this;
    }

    public String getRelevant_info() {
        return relevant_info;
    }

    public Answer setRelevant_info(String relevant_info) {
        this.relevant_info = relevant_info;
        return this;
    }

    public String getSuggest_edit() {
        return suggest_edit;
    }

    public Answer setSuggest_edit(String suggest_edit) {
        this.suggest_edit = suggest_edit;
        return this;
    }

    public String getReward_info() {
        return reward_info;
    }

    public Answer setReward_info(String reward_info) {
        this.reward_info = reward_info;
        return this;
    }

    public String getRelationship() {
        return relationship;
    }

    public Answer setRelationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer setQuestion(Question question) {
        this.question = question;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Answer setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public static class Question {

        private String type;

        private String id;

        private String title;

        private String question_type;

        private String created;

        private String updated_time;

        private String url;

        private String relationship;

        public Question() {
        }

        public Question(String type, String id, String title, String question_type, String created, String updated_time, String url, String relationship) {
            this.type = type;
            this.id = id;
            this.title = title;
            this.question_type = question_type;
            this.created = created;
            this.updated_time = updated_time;
            this.url = url;
            this.relationship = relationship;
        }

        public String getType() {
            return type;
        }

        public Question setType(String type) {
            this.type = type;
            return this;
        }

        public String getId() {
            return id;
        }

        public Question setId(String id) {
            this.id = id;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public Question setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getQuestion_type() {
            return question_type;
        }

        public Question setQuestion_type(String question_type) {
            this.question_type = question_type;
            return this;
        }

        public String getCreated() {
            return created;
        }

        public Question setCreated(String created) {
            this.created = created;
            return this;
        }

        public String getUpdated_time() {
            return updated_time;
        }

        public Question setUpdated_time(String updated_time) {
            this.updated_time = updated_time;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Question setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getRelationship() {
            return relationship;
        }

        public Question setRelationship(String relationship) {
            this.relationship = relationship;
            return this;
        }
    }

    public static class Author {

        private String id;

        private String url_token;

        private String name;

        private String avatar_url;

        private String avatar_url_template;

        private String is_org;

        private String type;

        private String url;

        private String user_type;

        private String headline;

        private String[] badge;

        private int gender;

        private String is_advertiser;

        private String is_followed;

        private String is_privacy;

        public Author() {
        }

        public Author(String id, String url_token, String name, String avatar_url, String avatar_url_template, String is_org, String type, String url, String user_type, String headline, String[] badge, int gender, String is_advertiser, String is_followed, String is_privacy) {
            this.id = id;
            this.url_token = url_token;
            this.name = name;
            this.avatar_url = avatar_url;
            this.avatar_url_template = avatar_url_template;
            this.is_org = is_org;
            this.type = type;
            this.url = url;
            this.user_type = user_type;
            this.headline = headline;
            this.badge = badge;
            this.gender = gender;
            this.is_advertiser = is_advertiser;
            this.is_followed = is_followed;
            this.is_privacy = is_privacy;
        }

        public String getId() {
            return id;
        }

        public Author setId(String id) {
            this.id = id;
            return this;
        }

        public String getUrl_token() {
            return url_token;
        }

        public Author setUrl_token(String url_token) {
            this.url_token = url_token;
            return this;
        }

        public String getName() {
            return name;
        }

        public Author setName(String name) {
            this.name = name;
            return this;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public Author setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
            return this;
        }

        public String getAvatar_url_template() {
            return avatar_url_template;
        }

        public Author setAvatar_url_template(String avatar_url_template) {
            this.avatar_url_template = avatar_url_template;
            return this;
        }

        public String getIs_org() {
            return is_org;
        }

        public Author setIs_org(String is_org) {
            this.is_org = is_org;
            return this;
        }

        public String getType() {
            return type;
        }

        public Author setType(String type) {
            this.type = type;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Author setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getUser_type() {
            return user_type;
        }

        public Author setUser_type(String user_type) {
            this.user_type = user_type;
            return this;
        }

        public String getHeadline() {
            return headline;
        }

        public Author setHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public String[] getBadge() {
            return badge;
        }

        public Author setBadge(String[] badge) {
            this.badge = badge;
            return this;
        }

        public int getGender() {
            return gender;
        }

        public Author setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public String getIs_advertiser() {
            return is_advertiser;
        }

        public Author setIs_advertiser(String is_advertiser) {
            this.is_advertiser = is_advertiser;
            return this;
        }

        public String getIs_followed() {
            return is_followed;
        }

        public Author setIs_followed(String is_followed) {
            this.is_followed = is_followed;
            return this;
        }

        public String getIs_privacy() {
            return is_privacy;
        }

        public Author setIs_privacy(String is_privacy) {
            this.is_privacy = is_privacy;
            return this;
        }
    }
}
