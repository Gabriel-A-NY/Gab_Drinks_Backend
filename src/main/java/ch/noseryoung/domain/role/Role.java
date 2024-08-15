package ch.noseryoung.domain.role;

import ch.noseryoung.domain.authority.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER) // Eager because it should load all data together
    @JoinTable(
            name = "role_authority",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_authority", referencedColumnName = "authority_id")
            }
    )
    private Set<Authority> authority;

}
