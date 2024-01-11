package CoBo.ChatbotChat.Data.Entity;

import CoBo.ChatbotChat.Data.Enum.ChatStateEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatRoom {

    @Id
    private Integer studentId;

    @Enumerated(EnumType.ORDINAL)
    private ChatStateEnum state;
}
