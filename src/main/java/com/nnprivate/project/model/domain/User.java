package com.nnprivate.project.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:srybakov@gmail.com">Sergey Rybakov</a>
 */
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "findByEmail", query = "select o from User o where email = :email")
})
public class User extends BaseEntity<Long>{

    private String email;
    private String password;
    private Date created;
    private List<UserRole> roles;

    public User(){

    }

    @Column(name = "email", length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name= "password", length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @PrePersist
    private void prePersistAction(){
        created = new Date();
    }
}
