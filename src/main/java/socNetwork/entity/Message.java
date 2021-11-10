package socNetwork.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


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
    private String content;




}
