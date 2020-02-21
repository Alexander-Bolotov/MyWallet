package MyWallet.domain.repository;

import MyWallet.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findAllByRole(String role);
}
