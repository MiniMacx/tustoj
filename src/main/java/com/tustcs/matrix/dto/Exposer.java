package com.tustcs.matrix.dto;

/**
 * Created by polykickshaw on 17-6-29.
 */
public class Exposer<T> {
    private boolean isExposed;
    private String url;
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

    public Exposer(boolean isExposed, String url, Integer exportId, T data) {
        this.isExposed = isExposed;
        this.url = url;
        this.data=data;
        this.exportId = exportId;
    }

    public Exposer(boolean isExposed, Integer exportId) {
        this.isExposed = isExposed;
        this.exportId = exportId;
    }

    public boolean getIsExposed() {
        return isExposed;
    }

    public void setIsExposed(boolean exposed) {
        isExposed = exposed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
