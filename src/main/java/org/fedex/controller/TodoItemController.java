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
    public String addEditItem(Model model){
        TodoItem todoItem = new TodoItem("","", LocalDate.now().toString());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;

    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem (@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todo item from form = {}", todoItem);
        todoItemService.addItem(todoItem);
        return "redirect:/"+Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        // removes item based on id number sent through the query in the url
        todoItemService.removeItem(id);

        return "redirect:/"+Mappings.ITEMS;

    }


}
