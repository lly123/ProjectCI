package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.web.Model;

import static com.freeroom.projectci.beans.ReportType.*;
import static com.freeroom.web.Model.render;

@Bean
public class HomeController {

    @Inject
    private ReportService reportService;

    public Model index()
    {
        return render("html:index.html").
                put("userStory", reportService.getCollection(UserStory)).
                put("highLevelDesign", reportService.getCollection(HighLevelDesign)).
                put("QSA", reportService.getCollection(QSA)).
                put("performanceTesting", reportService.getCollection(PerformanceTesting)).
                put("integrationTesting", reportService.getCollection(IntegrationTesting)).
                put("document", reportService.getCollection(Document));
    }
}
