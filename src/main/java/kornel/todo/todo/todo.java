package kornel.todo.todo;

import jakarta.persistence.*;

@Entity
@Table(name="todos")
public class todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer usernameID;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 400)
    private String description;
    @Column(nullable = false)
    private Boolean ready;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsernameID() {
        return usernameID;
    }

    public void setUsernameID(Integer usernameID) {
        this.usernameID = usernameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", usernameID=" + usernameID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ready=" + ready +
                '}';
    }
}