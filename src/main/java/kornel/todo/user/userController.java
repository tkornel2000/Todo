package kornel.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {
    @Autowired private userRespoitory repo;
    @GetMapping("/addNewUser")
    public String addNewUser(){
        return "createUser";
    }

    @PostMapping("/succesfullyAdded")
    public String save(user _user){
        repo.save(_user);
        return "succesfulTodo";
    }
}
