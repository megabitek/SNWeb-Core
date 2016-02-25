/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Role;
import entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Elena_Kholkina
 */
@Component
@Transactional
public class RoleRepository {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public RoleRepository() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public Long addRole(String title) {

        Session session = sessionFactory.getCurrentSession();
        Long roleID = null;
        Role role = new Role(title);
        roleID = (Long) session.save(role);
        return roleID;
    }

    public List<Role> listRoles() {

        Session session = sessionFactory.getCurrentSession();

        List<Role> roles = new ArrayList();
        roles = session.createQuery("FROM Users").list();

        for (Role role : roles) {

            System.out.println("Password: " + role.getTitle());
        }

        return roles;
    }

    public void updateRole(Long roleid, String title) {
        Session session = sessionFactory.getCurrentSession();
        Users user
                = (Users) session.get(Role.class, roleid);
        user.setPassword(title);

    }

    public void deleteRole(long roleid) {
        Session session = sessionFactory.getCurrentSession();

        Role role
                = (Role) session.get(Role.class, roleid);
        session.delete(role);

    }
}
