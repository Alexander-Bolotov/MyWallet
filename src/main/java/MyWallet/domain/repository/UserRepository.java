package MyWallet.domain.repository;

import MyWallet.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByName(String name);
}
