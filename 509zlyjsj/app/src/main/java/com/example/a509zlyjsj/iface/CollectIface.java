package com.example.a509zlyjsj.iface;

public interface CollectIface {
    void collect(String mod,int id,String sessionid,CollectListener listener);
    void uncollect(String mod,int id,String sessionid,CollectListener listener);
    void exist(String mod,int id,String sessionid,CollectListener listener);
}
