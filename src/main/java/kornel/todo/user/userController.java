package kornel.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {
    @Autowired private userService service;
    @GetMapping("/user/addNewUser")
    public String addNewUser(){
        return "createUser";
    }

    @PostMapping("/user/succesfullyAdded")
    public String save(user _user){
        service.save(_user);
        return "succesfulUser";
    }

    @GetMapping("/user/edit/{id}")
    public String editWindow(@PathVariable("id") Integer id, Model model) throws ExceptionUserNotFound {
        user User = service.getSpecificUser(id);
        model.addAttribute("user", User);
        return "editUser";
    }

    @PostMapping("/user/succesfullyEdited")
    public String edit(user _user) {
        service.save(_user);
        return "succesfulEdit";
    }
}
