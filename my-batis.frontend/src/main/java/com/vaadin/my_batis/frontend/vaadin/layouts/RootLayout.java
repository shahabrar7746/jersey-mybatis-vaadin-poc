package com.vaadin.my_batis.frontend.vaadin.layouts;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Layout;

@Layout
public class RootLayout extends AppLayout {
    RootLayout()
    {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add("grid layout");
        addToNavbar(verticalLayout);
    }
}
