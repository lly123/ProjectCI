package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.web.Model;

@Bean
public class ReportController {

    @Inject
    private ReportService reportService;

    @Inject
    private HomeController homeController;

    public Model create(final String httpMethod, final TimeReport report)
    {
        if ("POST".equals(httpMethod)) {
            reportService.addReport(report);
        }
        return homeController.index();
    }
}
