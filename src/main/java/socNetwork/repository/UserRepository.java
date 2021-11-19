package socNetwork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import socNetwork.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByName(String name);
    Page<User> findAll(Pageable pageable);
    User findUsersByAge(int age);
//    List<User> ;

}
