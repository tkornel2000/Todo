package kornel.todo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class todoService {
    @Autowired private todoRespoitory repo;
    public List<todo> listAll(){
        return (List<todo>) repo.findAll();
    }

    public todo getSpecificTodo(Integer id) throws ExceptionUserNotFound {
        Optional<todo> _todo = repo.findById(id);
        if(_todo.isPresent()){
            return _todo.get();
        }
        throw new ExceptionUserNotFound("User with this id was not found");
    }

    public void save(todo Todo) {
        repo.save(Todo);
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }

    public List<todo> getUserTodos(Integer id){
        List<todo> allTodo = (List<todo>) repo.findAll();
        List<todo> result=new ArrayList<todo>();
        for(todo Todo:allTodo){
            if(Todo.getUsernameID().equals(id)){
                result.add(Todo);
            }
        }
        return result;
    }


}
