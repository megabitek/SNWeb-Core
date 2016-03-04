/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Role;
import entity.Users;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Elena_Kholkina
 */
@Component
@Transactional
public class UserRepository {

    @Autowired
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public UserRepository() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long addUsers(Users user) {
        Session session = sessionFactory.getCurrentSession();
        Long employeeID;
        employeeID = (Long) session.save(user);
        return employeeID;
    }

    public List<Users> listUsers() {

        Session session = sessionFactory.getCurrentSession();

        List<Users> users = new ArrayList();
        users = session.createQuery("FROM Users").list();

        for (Users user : users) {
            System.out.print("Name: " + user.getUsername());
            System.out.print("Login: " + user.getLogin());
            System.out.println("Password: " + user.getPassword());
        }

        return users;
    }

    public void updateUser(Long userid, String password) {
        Session session = sessionFactory.getCurrentSession();
        Users user
                = (Users) session.get(Users.class, userid);
        user.setPassword(password);

    }

    public void deleteUser(long userid) {
        Session session = sessionFactory.getCurrentSession();

        Users user
                = (Users) session.get(Users.class, userid);
        session.delete(user);

    }

    public Users getUserByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("login", login));
        cr.add(Restrictions.eq("password", password));
        return (Users) cr.uniqueResult();
    }

    public Users getUserById(long userid) {
        Session session = sessionFactory.getCurrentSession();
        return (Users) session.get(Users.class, userid);
    }

    public Set<Role> getUserRoles(long userid) {
        Set<Role> roles = new HashSet();
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users) session.get(Users.class, userid);
        roles = user.getRoles();
        return roles;
    }

    public void deleteUserRoles(long userid, long roleid) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users) session.get(Users.class, userid);
        Role role = (Role) session.get(Role.class, roleid);
        user.getRoles().remove(role);
        session.save(user);

    }

    public void addUserRoles(long userid, long roleid) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users) session.get(Users.class, userid);
        Role role = (Role) session.get(Role.class, roleid);
        user.getRoles().add(role);
        session.save(user);
    }

}
