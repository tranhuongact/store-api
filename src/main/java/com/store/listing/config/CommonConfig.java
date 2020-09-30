package com.store.listing.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "commonconfig")
public class CommonConfig {
    private Boolean addHeaders;

    public Boolean getAddHeaders() {
        return addHeaders;
    }

    public void setAddHeaders(Boolean addHeaders) {
        this.addHeaders = addHeaders;
    }
}
