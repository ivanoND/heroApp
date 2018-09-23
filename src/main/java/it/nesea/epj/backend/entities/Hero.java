package it.nesea.epj.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    long id;

    @NotNull(message = "Hero's name cannot be null.")
    @Size(min = 3,message = "Lenght of hero's name cannot be < 3.")
    @Getter @Setter
    String name;

    @Email(message = "Email is not valid.")
    @Getter @Setter
    String email;

    public Hero(String name){
        this.name=name;
    }

}
