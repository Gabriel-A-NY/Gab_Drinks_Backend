package ch.noseryoung.domain.authority;

import ch.noseryoung.domain.role.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authority_id")
    @NotNull
    private Long id;

    @Column(name = "authority_name")
    private String name;

    @ManyToMany(mappedBy = "authority")
    @JsonBackReference
    private Set<Role> roles;

}
