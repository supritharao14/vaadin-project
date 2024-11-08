package com.example.demo.view.about;

import com.example.demo.view.mian.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "aboutComponent", layout = MainLayout.class)
public class AboutComponent extends VerticalLayout {

    AboutComponent()
    {
        build();
    }

    public void build() {
        add(new H1("Welcome to About view"));
    }
}
