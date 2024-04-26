package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
