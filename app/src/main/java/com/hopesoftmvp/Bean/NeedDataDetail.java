package com.hopesoftmvp.Bean;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/2/18.
 */
public class NeedDataDetail implements Serializable{

    private String expect;
    private String opencode;
    private String opentime;
    private String opentimestamp;

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getOpencode() {
        return opencode;
    }

    public void setOpencode(String opencode) {
        this.opencode = opencode;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getOpentimestamp() {
        return opentimestamp;
    }

    public void setOpentimestamp(String opentimestamp) {
        this.opentimestamp = opentimestamp;
    }
}
