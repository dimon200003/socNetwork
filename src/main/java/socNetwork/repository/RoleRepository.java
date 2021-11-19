package socNetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import socNetwork.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(String name);

}
