package com.example.demo.view.peopleList;

import com.example.demo.controller.PeopleRestController;
import com.example.demo.entity.People;
import com.example.demo.view.mian.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Route(value = "", layout = MainLayout.class)
public class PeopleListComponent extends VerticalLayout{

    private final PeopleRestController peopleRestController;
    private final PeopleForm peopleForm;
    Grid<People> grid = new Grid<>(People.class);
    private List<People> peopleList;

    public PeopleListComponent(PeopleRestController peopleRestController, PeopleForm peopleForm) {

        this.peopleRestController = peopleRestController;
        this.peopleForm = peopleForm;

        build();
    }

    public void build() {
        setSizeFull();
        VerticalLayout root = new VerticalLayout();
        root.setSizeFull();

        configureGrid();

        root.add(grid);
        root.setFlexGrow(3, grid);

        root.add(peopleForm);
        root.setFlexGrow(1, peopleForm);

        add(root);
    }

    private void configureGrid() {
        grid.addClassNames("people-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email");

        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(event -> editPeople(event.getValue()));
        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        peopleList = peopleRestController.getAllPeople();

        refreshGrid();

        addButtonToGrid();

    }

    private void addButtonToGrid() {
        grid.addComponentColumn(people -> {
            Button deleteButton = new Button("Delete");
            deleteButton.addClickListener(e -> {
                peopleRestController.deletePeople(people);
                refreshGrid();
            });
            return deleteButton;
        }).setHeader("Actions");
    }

    private void editPeople(People people) {
        peopleForm.setContact(people);
    }

    public void refreshGrid() {
        grid.setItems(peopleList);

    }

    public void setPeopleTOGrid(People people) {
        grid.setItems(peopleList);
    }
}
