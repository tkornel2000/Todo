package kornel.todo;
import kornel.todo.user.user;
import kornel.todo.user.userRespoitory;
import kornel.todo.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class controller {
    @Autowired private userRespoitory repo;
    @Autowired private userService service;
    @GetMapping("/")
    public String homePage(Model model){
        List<user> listUsers = service.listAll();
        model.addAttribute("listUsers",listUsers);
        return "user/index";
    }
}
