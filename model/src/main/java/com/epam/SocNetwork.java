package com.epam;

import entity.Role;
import entity.Users;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import repository.RoleRepository;
import repository.UserRepository;

public class SocNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-context.xml");
        UserRepository userrepo = (UserRepository) ctx.getBean("userRepo");
        try {
            long user = userrepo.addUsers(new Users("lena", "lena", "123"));

        } catch (DataIntegrityViolationException e) {
            System.out.println("not added");
        }
        userrepo.listUsers();
        RoleRepository rolerepo = (RoleRepository) ctx.getBean("roleRepo");
        try {
            Long addRole = rolerepo.addRole(new Role("administrator"));
        } catch (DataIntegrityViolationException e) {
            System.out.println("not added");
        }
        rolerepo.listRoles();
    }
}
