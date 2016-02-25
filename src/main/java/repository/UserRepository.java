/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

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

    public Long addUser(String username, String login, String password) {

        Session session = sessionFactory.getCurrentSession();
        Long employeeID = null;
        Users user = new Users(username, login, password);
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

}
