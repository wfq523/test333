package com.example.a509zlyjsj.iface;

public interface ArticleIface {
    void getResultList(String mod,
                       int page,
                       String sessionID,
                       ArticleListener listener
    );
}
