package com.yushan.rxjava.model;

/**
 * Created by beiyong on 2017-12-28.
 */

public class CheckIsOpenFarmResponse {

    /**
     * isopen : 1
     */

    private int isopen;

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }

    @Override
    public String toString() {
        return isopen + "";
    }
}
