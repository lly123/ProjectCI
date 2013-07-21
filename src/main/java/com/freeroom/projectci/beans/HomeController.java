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
                put("functionalTesting", reportService.getCollection(FunctionalTesting)).
                put("performanceTesting", reportService.getCollection(PerformanceTesting)).
                put("integrationTesting", reportService.getCollection(IntegrationTesting)).
                put("QSA", reportService.getCollection(QSA)).
                put("highLevelDesign", reportService.getCollection(HighLevelDesign)).
                put("documentWriting", reportService.getCollection(Document)).
                put("tickBar", reportService.getTickBar());
    }
}
