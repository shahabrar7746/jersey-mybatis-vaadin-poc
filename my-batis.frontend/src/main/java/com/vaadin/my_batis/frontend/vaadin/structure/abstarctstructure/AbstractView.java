package com.vaadin.my_batis.frontend.vaadin.structure.abstarctstructure;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Main;
import com.vaadin.my_batis.frontend.vaadin.structure.BaseView;

public abstract class AbstractView<P> extends Main implements BaseView<P> {
    public abstract void init();
}
