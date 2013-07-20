package com.freeroom.projectci.beans;

public class Collection {

    private ReportType type;

    private long totalEffort;

    private long usedEffort;

    public Collection(ReportType type, long totalEffort, long usedEffort) {
        this.type = type;
        this.totalEffort = totalEffort;
        this.usedEffort = usedEffort;
    }
}
