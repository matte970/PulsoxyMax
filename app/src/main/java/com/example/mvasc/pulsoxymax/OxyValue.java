package com.example.mvasc.pulsoxymax;

import java.util.Date;

public class OxyValue {

    private int oxy;
    private long time;

    public OxyValue(int oxy, long time) {
        this.oxy = oxy;
        this.time = time;
    }

    public int getOxy() {
        return oxy;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "OxyValue{" +
                "oxy=" + oxy +
                ", time=" + new Date(time) +
                '}';
    }
}