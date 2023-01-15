package kornel.todo.todo;

import org.springframework.data.repository.CrudRepository;

public interface todoRespoitory extends CrudRepository<todo,Integer> {
}
