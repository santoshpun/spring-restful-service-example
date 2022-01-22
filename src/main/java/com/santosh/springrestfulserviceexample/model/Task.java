package com.santosh.springrestfulserviceexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Task {
    private int id;
    private String summary;
    private String description;
    private Enum IssueType;
    private User reporter;
    private User assignee;
    private Date dueDate;
    private Date createdDate;
    private Date lastModifiedDate;
    private int percentageComplete;
}
