package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;
    @Column(name = "from_id")
    private int fromId;

    @Column(name =  "to_id")
    private int toId;

    @Column(name = "message_content")
    private String Content;


    public Message(int messageId, int fromId, String content, int toId) {
        this.messageId = messageId;
        this.fromId = fromId;
        Content = content;
        this.toId = toId;
    }

    public Message(int fromId, String content, int toId) {
        this.fromId = fromId;
        Content = content;
        this.toId = toId;
    }


}
