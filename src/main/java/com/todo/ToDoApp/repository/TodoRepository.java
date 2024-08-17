package com.todo.ToDoApp.repository;

import com.todo.ToDoApp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	@Query(value="select * from todo ORDER BY id DESC", nativeQuery = true)
	List<Todo> findAllTodo();
	
}
