package it.nesea.epj.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    long id;

    @NotNull(message = "Hero's name cannot be null.")
    @Size(min = 3,message = "Lenght of hero's name cannot be < 3.")
    @Getter @Setter
    String name;

    @Email(message = "Email is not valid.")
    @Getter @Setter
    String email;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "hero_ability",
            joinColumns = @JoinColumn(name = "hero_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    @Getter @Setter
    private Set<Ability> abilities = new HashSet<>();

    public Hero(String name){
        this.name=name;
    }
}
