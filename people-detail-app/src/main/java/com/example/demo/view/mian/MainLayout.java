package com.example.demo.view.mian;

import com.example.demo.view.about.AboutComponent;
import com.example.demo.view.name.NameComponent;
import com.example.demo.view.peopleList.PeopleListComponent;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.menubar.MenuBar;

public class MainLayout extends AppLayout {

    MenuBar menuBar;

    public MainLayout() {
        createMenubar();
        addToNavbar(menuBar);
    }

    private void createMenubar() {
        menuBar = new MenuBar();
        menuBar.addClassName("menubarMain");

        menuBar.addItem("Name",e -> getUI().ifPresent(ui -> ui.navigate(NameComponent.class)));
        menuBar.addItem("People List", e -> getUI().ifPresent(ui -> ui.navigate(PeopleListComponent.class)));
        menuBar.addItem("About", e -> getUI().ifPresent(ui -> ui.navigate(AboutComponent.class)));
    }

}
