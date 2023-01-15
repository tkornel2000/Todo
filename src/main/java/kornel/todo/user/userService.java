package kornel.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    @Autowired private userRespoitory repo;
    public List<user> listAll(){
        return (List<user>) repo.findAll();
    }

    public user getSpecificUser(Integer id) throws ExceptionUserNotFound {
        Optional<user> _user = repo.findById(id);
        if(_user.isPresent()){
            return _user.get();
        }
        throw new ExceptionUserNotFound("User with this id was not found");
    }

    public void save(user User) {
        repo.save(User);
    }


}
