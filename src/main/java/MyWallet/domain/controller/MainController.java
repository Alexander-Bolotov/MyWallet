package MyWallet.domain.controller;

import MyWallet.domain.model.Role;
import MyWallet.domain.model.User;
import MyWallet.domain.repository.RoleRepository;
import MyWallet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    static final String USER_LIST = "/list";
    static final String USER_FORM = "/user-form";
    static final String USER_DATA = "/userdata";

    @GetMapping("/index")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name");
        return "/login";
    }

    @RequestMapping(value = USER_LIST)
    public String messages(Model model) {
        model.addAttribute("userList", userRepository.findAll());

        return USER_LIST;
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam("userId") long id, Model model) {
        if (id == -1) {
            User user = new User();
            model.addAttribute("user", user);
            return USER_FORM;
        }
        List<Role> roles = roleRepository.findAll();
        User user = userRepository.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return USER_FORM;
    }

//    @RequestMapping(value = "/saveUser")
//    public String saveUser( @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("roles") Set<Role> role) {
//        if (userRepository.findAllByName(name) != null) {
//            User user = userRepository.findAllByName(name);
//            user.setName(name);
//            user.setPassword(password);
//            user.setRoles(role);
//            userRepository.save(user);
//        } else {
//            User user = new User(name, password, role);
//            userRepository.save(user);
//        }
//        return "redirect:/mainPage";
//    }

    @RequestMapping(value = "/updateUser")
    public String updateUser( @RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("roles") Set<Role> role) {
        User updateUser = userRepository.getOne(id);
        updateUser.setName(name);
        updateUser.setPassword(password);
        updateUser.setRoles(role);
        userRepository.save(updateUser);
        return "redirect:/mainPage";
    }


    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("userId") long id, Model model) {
        userRepository.deleteById(id);
        return "redirect:/mainPage";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(@RequestParam("userId") long id, Model model) {
        Set<Role> userRoles = new HashSet<>(roleRepository.findAll());
        List<User> userList = userRepository.findAll();
        int i = userList.size();
        Long idLast = userList.get(i - 1).getId();
        User user = new User();
        user.setId(idLast + 1);
        user.setName("");
        user.setPassword("");
        user.setRoles(userRoles);

        model.addAttribute("user", user);
        model.addAttribute("roles", userRoles);
        return USER_FORM;
    }

    @RequestMapping(value = "/userdata")
    public String userdata(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findAllByName(auth.getName());
        model.addAttribute("user", user);
        return USER_DATA;
    }

    @RequestMapping(value = "/login")
    public String getLoginPage(Model model) {
        return "/login";
    }

    @RequestMapping(value = "/mainPage")
    public String getMainPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findAllByName(auth.getName());
        Set<Role> userRoles = new HashSet<>(roleRepository.findAll());



        User saveUser = new User();
        saveUser.setName("");
        saveUser.setPassword("");
        saveUser.setRoles(userRoles);


        model.addAttribute("userAuth", user);
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("saveUser", saveUser);
        model.addAttribute("roles", userRoles);
        model.addAttribute("user", user);


        return "/mainPage";
    }
}
