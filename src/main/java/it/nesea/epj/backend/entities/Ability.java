package it.nesea.epj.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    long id;

    @NotNull
    @UniqueElements
    String description;

    @ManyToMany(mappedBy = "abilities")
    private Set<Hero> posts = new HashSet<>();

    public Ability(@NotNull String description) {
        this.description = description;
    }
}
