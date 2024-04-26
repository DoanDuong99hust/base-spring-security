package sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.constant.RoleEnum;
import sg.gov.cpf.gpg.springcloud.cloudsecurityserverdemo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
