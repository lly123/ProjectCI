package com.freeroom.projectci.beans;

public enum ReportType {
    UserStory(333), HighLevelDesign(10), Document(20), QSA(3), PerformanceTesting(20), IntegrationTesting(10);

    private long estimatedEffort;

    ReportType(long estimatedDays) {
        this.estimatedEffort = estimatedDays * 8;
    }

    public long getEstimatedEffort() {
        return estimatedEffort;
    }
}
