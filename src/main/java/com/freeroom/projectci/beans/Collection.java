package com.freeroom.projectci.beans;

import static java.lang.Math.round;

public class Collection {

    private ReportType type;

    private long estimatedEffort;

    private long usedEffort;

    private int percentage;

    public Collection(ReportType type, long estimatedEffort, long usedEffort) {
        this.type = type;
        this.estimatedEffort = estimatedEffort;
        this.usedEffort = usedEffort;
        this.percentage = usedEffort > estimatedEffort ? 100 : (int) round(((double) usedEffort / estimatedEffort) * 100);
    }
}
