package net.jcornelio.projects.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import net.jcornelio.projects.springboot.web.model.Todo;

/**
 * The Class TodoService.
 */
@Service
public class TodoService {

  /** The todos. */
  private static List<Todo> todos = new ArrayList<>();

  static {
    todos.add(new Todo(1, "Juan", "Learn Spring MVC", new Date(), false));
    todos.add(new Todo(2, "Juan", "Learn Struts", new Date(), false));
    todos.add(new Todo(3, "Juan", "Learn Hibernate", new Date(), false));
  }

  /**
   * Retrieve todos.
   *
   * @param user the user
   * @return the list
   */
  public List<Todo> retrieveTodos(String user) {
    List<Todo> filteredTodos = new ArrayList<>();
    for (Todo todo : todos) {
      if (todo.getUser().equals(user)) {
        filteredTodos.add(todo);
      }
    }
    return filteredTodos;
  }

  /**
   * Adds the todo.
   *
   * @param name the name
   * @param desc the desc
   * @param targetDate the target date
   * @param isDone the is done
   */
  public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
    todos.add(new Todo(todos.size() + 1, name, desc, targetDate, isDone));
  }

  /**
   * Delete todo.
   *
   * @param id the id
   */
  public void deleteTodo(int id) {
    Iterator<Todo> iterator = todos.iterator();
    while (iterator.hasNext()) {
      Todo todo = iterator.next();
      if (todo.getId() == id) {
        iterator.remove();
      }
    }
  }

}
