package br.com.luigipietro.springwebmvc.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jedi {
    @Id
    private Long id;

    @Column
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String name;

    @Column
    @NotBlank
    @Size(min = 5, max = 20, message = "Last Name must not have more than 20 letters")
    private String lastName;
}
