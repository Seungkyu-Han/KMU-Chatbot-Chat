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
public class Chat {

    @Id
    private Integer id;

    private Integer studentId;

    private String comment;

    private LocalDateTime createdAt;

    private Boolean question;

    @Builder
    public Chat(Integer id, Integer studentId, String comment, Boolean question) {
        this.id = id;
        this.studentId = studentId;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.question = question;
    }
}
