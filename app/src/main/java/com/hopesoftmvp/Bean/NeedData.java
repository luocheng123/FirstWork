package com.hopesoftmvp.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2017/2/18.
 */
public class NeedData implements Serializable{

    private String rows;
    private String code;
    private String info;
    private List<NeedDataDetail> data;

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<NeedDataDetail> getData() {
        return data;
    }

    public void setData(List<NeedDataDetail> data) {
        this.data = data;
    }
}
