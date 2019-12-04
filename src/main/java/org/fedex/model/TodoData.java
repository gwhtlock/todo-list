package org.fedex.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // == fields ==
    private static int idValue = 1;
    // making List field final prevents the List from being chaged to a different type of list but items can still be added to the list
    private final List<TodoItem> items = new ArrayList<>();

    // == constructors ==
    public TodoData() {

        // add some dummy data, using add item method to set te id field
        addItem(new TodoItem("First", "first details", LocalDate.now().toString()));
        addItem(new TodoItem("Second", "Second details", LocalDate.now().toString()));
        addItem(new TodoItem("Third", "Third details", LocalDate.now().toString()));
        addItem(new TodoItem("Fourth", "Fourth details", LocalDate.now().toString()));
        addItem(new TodoItem("Fifth", "Fifth details", LocalDate.now().toString()));
    }

    // public methods
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd){
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if(item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for(TodoItem item : items){
            if(item.getId() == id){
                return item;
            }
        }

        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){

            TodoItem item = itemIterator.next();

            if(item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }

        }
    }




}
