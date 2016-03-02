/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositoryTest;

import entity.Role;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.RoleRepository;

/**
 *
 * @author Elena_Kholkina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
@Transactional
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository rolerepo;

    public RoleRepository getRolerepo() {
        return rolerepo;
    }

    public void setRolerepo(RoleRepository rolerepo) {
        this.rolerepo = rolerepo;
    }

    @Test
    public void addRole() {
        int count = rolerepo.listRoles().size();
        Role role = new Role("test");
        rolerepo.addRole(role);
        Assert.assertEquals(rolerepo.listRoles().size(), count + 1);

    }

    @Test
    public void deleteRole() {
        Role role = new Role("test");
        Long roleid = rolerepo.addRole(role);
        int count = rolerepo.listRoles().size();
        rolerepo.deleteRole(roleid);
        Assert.assertEquals(count-1, rolerepo.listRoles().size());
    }
    
    
}
