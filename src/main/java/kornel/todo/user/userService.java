package kornel.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    @Autowired private userRespoitory repo;
    public List<user> listAll(){
        return (List<user>) repo.findAll();
    }
}
