package MyWallet.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class Transaction {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "expenseWallet")
    private Wallet expenseWallet;

    @Column(name = "incomeWallet")
    private Wallet incomeWallet;

    @Column(name = "sum")
    private int sum;

    @Column(name = "user")
    private User user;

    @Column(name = "subjectOfTransaction")
    private SubjectOfTransaction subjectOfTransaction;

    @Column(name = "comment")
    private String comment;

    public Transaction() {
    }

    public Transaction(Long id, Date date, Wallet expenseWallet, Wallet incomeWallet, int sum, User user, SubjectOfTransaction subjectOfTransaction, String comment) {
        this.id = id;
        this.date = date;
        this.expenseWallet = expenseWallet;
        this.incomeWallet = incomeWallet;
        this.sum = sum;
        this.user = user;
        this.subjectOfTransaction = subjectOfTransaction;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Wallet getExpenseWallet() {
        return expenseWallet;
    }

    public void setExpenseWallet(Wallet expenseWallet) {
        this.expenseWallet = expenseWallet;
    }

    public Wallet getIncomeWallet() {
        return incomeWallet;
    }

    public void setIncomeWallet(Wallet incomeWallet) {
        this.incomeWallet = incomeWallet;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubjectOfTransaction getSubjectOfTransaction() {
        return subjectOfTransaction;
    }

    public void setSubjectOfTransaction(SubjectOfTransaction subjectOfTransaction) {
        this.subjectOfTransaction = subjectOfTransaction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
