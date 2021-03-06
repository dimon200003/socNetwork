package socNetwork.repository;

import org.springframework.stereotype.Repository;
import socNetwork.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findMessageByContent(String content);

}
