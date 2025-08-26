package com.framework.goodhealthgateway.android.utils;
public class Language {
    private String language;
    private String enable;

    public Language() {
        super();
    }

    public Language(String language, String enable) {
        super();
        this.language = language;
        this.enable = enable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                ", enable='" + enable + '\'' +
                '}';
    }
}