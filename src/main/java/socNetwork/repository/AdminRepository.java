package socNetwork.repository;

import socNetwork.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findAdminByAdminLogin(String adminLogin);
}
