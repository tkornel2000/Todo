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
        return "user/createUser";
    }

    @PostMapping("/user/succesfullyAdded")
    public String saveUser(user _user){
        service.save(_user);
        return "succesfulCreate";
    }

    @GetMapping("/user/edit/{id}")
    public String editUserWindow(@PathVariable("id") Integer id, Model model) throws ExceptionUserNotFound {
        user User = service.getSpecificUser(id);
        model.addAttribute("user", User);
        return "user/editUser";
    }

    @PostMapping("/user/succesfullyEdited")
    public String editUserSuccesfully(user _user) {
        service.save(_user);
        return "succesfulEdit";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserWindow(@PathVariable("id") Integer id){
        service.delete(id);
        return "succesfulDelete";
    }
}
