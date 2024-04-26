package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.constant.RoleEnum;

import java.util.Set;

@Entity
@Table(name = "GPG_ROLE")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column
    private RoleEnum value;

    @Column
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleEnum getValue() {
        return value;
    }

    public Role setValue(RoleEnum value) {
        this.value = value;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
