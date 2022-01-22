package com.santosh.springrestfulserviceexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
    private int id;
    private String name;

    public Department(int id){
        this.id = id;
    }
}
