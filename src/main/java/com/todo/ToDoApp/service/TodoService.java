package com.todo.ToDoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.ToDoApp.Entity.Todo;
import com.todo.ToDoApp.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAllTodo();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void updateTodoStatus(Long id, boolean completed) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(completed);
        todoRepository.save(todo);
    }
}
