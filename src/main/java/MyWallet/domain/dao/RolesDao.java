package MyWallet.domain.dao;

import MyWallet.domain.model.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface RolesDao {
    List<Role> getListRoles();

    boolean roleIsExist(String role);

    Role getRoleByName(String roleName);
}
