package com.linkcurto.encurtadorDeLinks.dto;

public class CreateLinkRequest {
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl){
        this.originalUrl = originalUrl;
    }
}
