package kornel.todo.todo;

import kornel.todo.ActualUser;
import kornel.todo.user.user;
import kornel.todo.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class todoController {
    @Autowired private todoService service;
    @Autowired private userService userservice;
    private ActualUser actUser;

    @GetMapping("/{id}/todo")
    public String homePage(@PathVariable Integer id, Model model) throws kornel.todo.user.ExceptionUserNotFound {
        actUser = new ActualUser(id);
        actUser.setActUser(id);
        List<todo> todos= service.getUserTodos(id);
        model.addAttribute("todos",todos);

        return "todo/indexTodo";
    }
    @GetMapping("/todo/addNewTodo")
    public String addNewTodo(){
        return "todo/createTodo";
    }

    @PostMapping("todo/succesfullyAdded")
    public String saveTodo(todo _todo){
        //_todo.setUsernameID(actUser.getActUser());
        if(actUser==null){
            actUser = new ActualUser(999);
        }
        _todo.setUsernameID(actUser.getActUser());
        _todo.setReady(false);
        service.save(_todo);
        return "succesfulCreate";
    }

    @GetMapping("{userid}/todo/edit/{id}")
    public String editTodoWindow(@PathVariable("id") Integer id,
                                 Model model) throws ExceptionUserNotFound, kornel.todo.user.ExceptionUserNotFound {
        todo Todo = service.getSpecificTodo(id);
        model.addAttribute("todo",Todo);
        return "todo/editTodo";
    }

    @PostMapping("/todo/succesfullyEdited")
    public String editTodoSuccesfully(todo Todo) {
        service.save(Todo);
        return "succesfulEdit";
    }

    @GetMapping("{usernameid}/todo/delete/{id}")
    public String deleteUserWindow(@PathVariable("id") Integer id){
        service.delete(id);
        return "succesfulDelete";
    }

    @GetMapping("/todo/allTodo")
    public String allTodo(Model model){
        List<todo> todos = service.listAll();
        model.addAttribute("todos",todos);
        return "todo/indexTodo";
    }
}
