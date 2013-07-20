package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.persistence.Athena;

import java.util.List;

import static com.freeroom.projectci.beans.ReportType.UserStory;

@Bean
public class ReportService {

    private static final long ALLOCATED_USER_STORY_EFFORT = 308;

    @Inject
    private Athena athena;

    public Collection getUserStoryCollection()
    {
        return new Collection(UserStory, ALLOCATED_USER_STORY_EFFORT,
                calUsedEffort(athena.from(TimeReport.class).find("type='UserStory'")));
    }

    private long calUsedEffort(List<Object> reports) {
        long usedEffort = 0;
        for (Object report : reports) {
            usedEffort += ((TimeReport) report).getHours();
        }
        return usedEffort;
    }

    public void addReport(TimeReport report) {
        athena.persist(report);
    }
}
