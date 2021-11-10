package socNetwork.service.impl;

import socNetwork.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socNetwork.repository.MessageRepository;
import socNetwork.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        Message createdMessage = messageRepository.saveAndFlush(message);
        return createdMessage;
    }

    @Override
    public void delete(int id) {
        messageRepository.deleteById(id);

    }

    @Override
    public Message getByContent(String content) {
        return messageRepository.findMessageByContent(content);
    }

    @Override
    public Message editMessage(Message message) {
        return messageRepository.saveAndFlush(message);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }
}
