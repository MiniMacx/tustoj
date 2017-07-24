package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.ContestProblem;

import javax.xml.crypto.Data;

/**
 * Created by polykickshaw on 17-6-29.
 */
public class Exposer<T> {
    private boolean isExposed;
    private String md5;
    private Integer exportId;
    private T data;
    private long now;
    private long start;
    private long end;


    public Exposer(boolean isExposed, Integer exportId, long now, long start, long end) {
        this.isExposed = isExposed;
        this.exportId = exportId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean isExposed, String md5, Integer exportId,T data) {
        this.isExposed = isExposed;
        this.md5 = md5;
        this.data=data;
        this.exportId = exportId;
    }

    public Exposer(boolean isExposed, Integer exportId) {
        this.isExposed = isExposed;
        this.exportId = exportId;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Integer getExportId() {
        return exportId;
    }

    public void setExportId(Integer exportId) {
        this.exportId = exportId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
