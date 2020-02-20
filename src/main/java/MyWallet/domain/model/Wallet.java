package MyWallet.domain.model;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "users")
public class Wallet {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "currency")
    private Currency currency;

    @Column(name = "sum")
    private int sum;

    @Column(name = "minSum")
    private int minSum;

    @Column(name = "userOwner")
    private User userOwner;

    @Column(name = "typeOfTransaction")
    private TypeOfTransaction typeOfTransaction;
}
