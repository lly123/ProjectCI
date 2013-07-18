package com.freeroom.projectci.beans;

import com.freeroom.web.Model;

import static com.freeroom.web.Model.render;

public class HomeController {

    public Model index()
    {
        return render("html:index.html");
    }
}
