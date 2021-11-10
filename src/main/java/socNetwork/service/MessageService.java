package socNetwork.service;



import socNetwork.entity.Message;

import java.util.List;

public interface MessageService {
    Message addMessage(Message message);
    void delete(int id);
    Message getByContent(String content);
    Message editMessage(Message message);
    List<Message> getAll();
}
