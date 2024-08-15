package ch.noseryoung.domain.authority;

import ch.noseryoung.domain.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Authority {
    @Id
    @Column(name = "authority_id")
    @NotNull
    private Long id;

    @Column(name = "authority_name")
    private String name;

    @ManyToMany(mappedBy = "authority")
    private Set<Role> roles;

}
