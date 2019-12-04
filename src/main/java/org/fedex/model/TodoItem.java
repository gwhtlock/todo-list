package org.fedex.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of ="id")
public class TodoItem {

    // == fields ==
    private int id;
    private String title;
    private String details;
    private String deadline;

    // == constructors ==
    public TodoItem(String title, String details, String deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }



}
