package MyWallet.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "group")
    private String group;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<SubjectOfTransaction> subjectOfTransactionSet;

}
