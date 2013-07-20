package com.freeroom.projectci.beans;

import com.freeroom.di.annotations.Bean;
import com.freeroom.di.annotations.Inject;
import com.freeroom.web.Model;

import static com.freeroom.web.Model.render;

@Bean
public class HomeController {

    @Inject
    private ReportService reportService;

    public Model index()
    {
        return render("html:index.html").
                put("userStory", reportService.getUserStoryCollection());
    }
}
