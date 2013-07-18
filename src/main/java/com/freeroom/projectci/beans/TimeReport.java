package com.freeroom.projectci.beans;

import com.freeroom.persistence.annotations.ID;
import com.freeroom.persistence.annotations.Persist;
import com.freeroom.persistence.proxy.IdPurpose;

public class TimeReport {
    @ID
    private long id;

    @Persist
    private long reportDate;

    @Persist
    private TeamMember person;

    @Persist
    private ReportType reportType;

    @Persist
    private long hours;

    @Persist
    private String comment;

    private IdPurpose idPurpose;
}
