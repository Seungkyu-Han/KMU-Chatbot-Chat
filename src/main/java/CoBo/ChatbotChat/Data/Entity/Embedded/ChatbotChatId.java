package CoBo.ChatbotChat.Data.Entity.Embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatbotChatId implements Serializable {

    private Integer studentId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
