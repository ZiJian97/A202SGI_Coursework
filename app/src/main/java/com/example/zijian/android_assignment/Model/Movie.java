package com.example.zijian.android_assignment.Model;

/**
 * Created by Zi Jian on 1/12/2017.
 */

public class Movie {
    public String title,summary,url;

    public Movie (String title, String url, String summary)
    {
        this.title = title;
        this.summary = summary;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
