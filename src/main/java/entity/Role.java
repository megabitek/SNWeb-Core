/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Elena_Kholkina
 */
@Entity
@Table(name = "role")

public class Role {

    @Id
    @GeneratedValue
    @Column(name = "roleid")
    private Long roleid;
    
    @Column(name = "title")
    private String title;

    @OneToMany
    List<UserRole> roles;

    public Role() {
    }

    public Role(String title) {
        this.title = title;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
