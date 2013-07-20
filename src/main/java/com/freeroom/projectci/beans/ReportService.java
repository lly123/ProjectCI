package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.persistence.Athena;

import java.util.List;

import static java.lang.String.format;

@Bean
public class ReportService {

    @Inject
    private Athena athena;

    public Collection getCollection(ReportType type)
    {
        return new Collection(type, type.getEstimatedEffort(),
                calculateUsedEffort(athena.from(TimeReport.class).find(format("type='%s'", type))));
    }

    private long calculateUsedEffort(List<Object> reports) {
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
