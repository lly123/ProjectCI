package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.persistence.Athena;
import com.freeroom.util.Pair;
import org.joda.time.DateTime;
import org.joda.time.Days;

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

    public Pair<Integer, Integer> getTickBar() {
        final DateTime now = new DateTime();
        final DateTime begin = new DateTime(2013, 6, 4, 0, 0, 0);
        final DateTime end = new DateTime(2013, 12, 30, 0, 0, 0);

        return Pair.of(Days.daysBetween(begin, end).getDays(), Days.daysBetween(begin, now).getDays());
    }

    public void addReport(TimeReport report) {
        athena.persist(report);
    }

    private long calculateUsedEffort(List<Object> reports) {
        long usedEffort = 0;
        for (Object report : reports) {
            usedEffort += ((TimeReport) report).getHours();
        }
        return usedEffort;
    }
}
