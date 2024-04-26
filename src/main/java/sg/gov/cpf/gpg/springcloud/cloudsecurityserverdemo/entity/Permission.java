package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.constant.PermissionEnum;

import java.util.Set;

@Entity
@Table(name = "GPG_PERMISSION")
public class Permission {

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;

    @Column
    private PermissionEnum value;

    @Column
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<User> users;

    public Permission() {
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.description = description;
        return this;
    }

    public PermissionEnum getValue() {
        return value;
    }

    public Permission setValue(PermissionEnum value) {
        this.value = value;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
