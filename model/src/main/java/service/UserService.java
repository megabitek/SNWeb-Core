/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Role;
import entity.Users;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.RoleRepository;
import repository.UserRepository;

/**
 *
 * @author Elena_Kholkina
 */
@Service("userservice")
@Transactional
public class UserService {

    @Autowired
    @Resource(name = "userRepo")
    private UserRepository userrepo;

    @Autowired
    @Resource(name = "roleRepo")
    private RoleRepository rolerepo;

    public void addUserWithRoles(String username, String password, String login, Long[] roles) {
        Users user = new Users(username, login, password);
        Long addUsers = userrepo.addUsers(user);
        Set<Role> userroles = user.getRoles();
        for (Long role : roles) {
            userrepo.addUserRoles(addUsers, role);
        }
    }

    public Long addUser(String username, String login, String password) {
        Users user = new Users(username, login, password);
        return userrepo.addUsers(user);
    }

    public Users findUserByLoginAndPasword(String username, String password) {
        return userrepo.getUserByLoginAndPassword(username, password);
    }

}
