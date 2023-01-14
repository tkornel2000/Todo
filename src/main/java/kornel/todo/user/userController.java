package kornel.todo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {
    @GetMapping("/addNewUser")
    public String addNewUser(){
        return "createUser";
    }
}
