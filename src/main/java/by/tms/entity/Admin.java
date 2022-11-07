package by.tms.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class Admin extends AbstractUser {
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Enter correct name!", regexp = "admin")
    private String name;
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Enter correct name!", regexp = "admin")
    private String password;



    public Admin(String name, String username, String password) {
        super(name, username, password, Role.ADMIN);
        this.name = name;
        this.password = password;
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Admin() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }


}
