package com.marcel.entity;

import javafx.beans.property.*;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    private final IntegerProperty id= new SimpleIntegerProperty();
    private final StringProperty name= new SimpleStringProperty();
    private final ObjectProperty<Date> expiredDate;

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int value) {
        this.id.set(value);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String value) {
        this.name.set(value);
    }

    public Date getExpiredDate() {
        return expiredDate.get();
    }

    public ObjectProperty<Date> expiredDateProperty() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate.set(expiredDate);
    }

    public Item(ObjectProperty<Date> expiredDate) {
        this.expiredDate = expiredDate;
    }

    public void setId(String trim) {
    }
}
