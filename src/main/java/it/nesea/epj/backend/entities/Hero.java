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

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Getter
    long id;

    @NotNull @Size(min = 3) @Getter @Setter
    String name;

    @Email @Getter @Setter
    String email;
}
