package com.example.demo.view.name;

import com.example.demo.view.mian.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route(value = "nameComponent", layout = MainLayout.class)
public class NameComponent extends VerticalLayout {

    NameComponent() {
        build();
    }

    public void build() {
        add(new H1("Welcome to Name view"));
    }
}
