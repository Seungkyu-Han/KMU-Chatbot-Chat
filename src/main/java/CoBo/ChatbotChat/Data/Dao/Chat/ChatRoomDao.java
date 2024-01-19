package CoBo.ChatbotChat.Data.Dao.Chat;


import CoBo.ChatbotChat.Data.Enum.ChatStateEnum;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class ChatRoomDao {

    private Integer student_id;

    private String name;

    private ChatStateEnum state;

    private String comment;

    private LocalDateTime created_at;

    public ChatRoomDao(Integer student_id, String name, Integer state, String comment, Timestamp created_at) {
        this.student_id = student_id;
        this.name = name;
        this.state = ChatStateEnum.values()[state];
        this.comment = comment;
        this.created_at = created_at.toLocalDateTime();
    }
}
