package it.nesea.epj.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    long id;

    @NotNull
    @Getter
    @Setter
    String description;


    @ManyToMany(mappedBy = "abilities", fetch=FetchType.EAGER)
    private Set<Hero> heroes = new HashSet<>();

    public Ability(@NotNull String description) {
        this.description = description;
    }
}
