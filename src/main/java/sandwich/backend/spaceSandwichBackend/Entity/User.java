package sandwich.backend.spaceSandwichBackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Size(min = 3, message = " min 3 chars")
    private String username;

    @Column
    @Size(min = 6, message = "min 6 chars.")
    @JsonIgnore
    private String password;

    @Column
    private String roles;


    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}