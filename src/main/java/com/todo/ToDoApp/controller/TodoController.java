package com.todo.ToDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.todo.ToDoApp.Entity.Todo;
import com.todo.ToDoApp.service.TodoService;
// jiijihiuhiuh
giuguig
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todoList", todoService.getAllTodos());
        model.addAttribute("newTodo", new Todo());
        return "index";
    }
    
    

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute("newTodo") Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/updateTodoStatus")
    public String updateTodoStatus(@RequestParam("id") Long id, @RequestParam("completed") boolean completed) {
        todoService.updateTodoStatus(id, completed);
        return "redirect:/";
    }
}
