package org.fedex.controller;

import lombok.extern.slf4j.Slf4j;
import org.fedex.model.TodoData;
import org.fedex.model.TodoItem;
import org.fedex.service.TodoItemService;
import org.fedex.util.AttributeNames;
import org.fedex.util.Mappings;
import org.fedex.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }


    // == model attribute section --
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == handler methods ==

    //http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_lIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue ="-1") int id, Model model){

        log.info("Editing id= {}",id);
        TodoItem todoItem = todoItemService.getItem(id);

        if(todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now().toString());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;

    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem (@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todo item from form = {}", todoItem);

        if(todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
        }else{
            todoItemService.updateItem(todoItem);
        }


        return "redirect:/"+Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id: {}",id);
        // removes item based on id number sent through the query in the url
        todoItemService.removeItem(id);

        return "redirect:/"+Mappings.ITEMS;

    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        log.info("viewing item with id: {}",id);
        // gets single item based on id number sent through the query in the url
        TodoItem item = todoItemService.getItem(id);
        //string item is the variable name that the model will use to give access to the data in the view
        model.addAttribute("item", item);


        return Mappings.VIEW_ITEM;

    }


}
