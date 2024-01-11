package CoBo.ChatbotChat.Data.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ChatbotChat {

    @Id
    private Long id;

    private Integer studentId;

    private String question;

    private String answer;

    private LocalDateTime createdAt;

    @Builder
    public ChatbotChat(Long id, Integer studentId, String question, String answer) {
        this.id = id;
        this.studentId = studentId;
        this.question = question;
        this.answer = answer;
        this.createdAt = LocalDateTime.now();
    }
}
