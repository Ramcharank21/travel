package com.aem.community.core.service;

import javax.annotation.PostConstruct;

public interface StaticDataSourceModel {
    @PostConstruct
    void init();
}
