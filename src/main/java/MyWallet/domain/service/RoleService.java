package MyWallet.domain.service;

import MyWallet.domain.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRoles();

    boolean roleIsExist(String role);

    Role getRoleByName(String roleName);
}
