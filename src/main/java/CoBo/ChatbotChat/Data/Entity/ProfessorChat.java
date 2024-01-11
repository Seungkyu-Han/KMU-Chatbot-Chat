package CoBo.ChatbotChat.Data.Entity;

import CoBo.ChatbotChat.Data.Entity.Embedded.ProfessorChatId;
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
public class ProfessorChat {

    @EmbeddedId
    private ProfessorChatId professorChatId;

    private String comment;

    private LocalDateTime createdAt;

    private Boolean question;
}
