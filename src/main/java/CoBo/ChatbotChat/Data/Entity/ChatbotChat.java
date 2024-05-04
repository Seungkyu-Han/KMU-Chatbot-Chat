package CoBo.ChatbotChat.Data.Entity;

import CoBo.ChatbotChat.Data.Entity.Embedded.ChatbotChatId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatbotChat {

    @EmbeddedId
    private ChatbotChatId chatbotChatId;

    private String question;

    private String answer;

    private LocalDateTime created_at;
}
