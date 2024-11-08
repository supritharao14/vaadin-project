package com.example.demo.view.peopleList;

import com.example.demo.controller.PeopleRestController;
import com.example.demo.entity.People;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class PeopleForm extends VerticalLayout {

    @Autowired
    @Lazy
    PeopleListComponent peopleListComponent;

    PeopleRestController peopleRestController;

    TextField firstName;
    TextField lastName;
    TextField email;
    Binder<People> binder = new Binder<>(People.class);
    private People people;

    public PeopleForm(PeopleRestController peopleRestController) {
        this.peopleRestController = peopleRestController;

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        createFormFields();

        bindValidation();

        horizontalLayout.add(firstName, lastName, email, getButton());

        horizontalLayout.setAlignItems(Alignment.BASELINE);
        add(horizontalLayout);
    }

    private void createFormFields() {
        firstName = new TextField("Name");
        lastName = new TextField("LastName");
        email = new TextField("Email");
    }

    private Button getButton() {
        Button save = new Button("Save");
        save.addClickListener(e -> addPeople());
        return save;
    }

    private void bindValidation() {
        binder.forField(email)
                .withValidator(new EmailValidator(
                        "This doesn't look like a valid email address"))
                .bind(People::getEmail, People::setEmail);

        binder.forField(firstName)
                .withValidator(
                        name -> name.length() >= 3,
                        "Name must contain at least three characters")
                .bind(People::getFirstName, People::setFirstName);

        binder.forField(lastName)
                .asRequired("Every name must have Sirname")
                .bind(People::getLastName, People::setLastName);
    }

    public void setContact(People people) {
        this.people = people;
        binder.readBean(people);
    }

    private void addPeople() {
        if (people == null)
            people = new People();

        binder.writeBeanIfValid(people);

        peopleRestController.addPeople(people);
        peopleListComponent.refreshGrid();
        clearForm();
        people = null;
    }

    private void clearForm() {
        binder.setBean(new People());
    }
}
