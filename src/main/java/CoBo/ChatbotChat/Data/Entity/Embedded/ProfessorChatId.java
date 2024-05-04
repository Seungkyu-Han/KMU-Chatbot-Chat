package CoBo.ChatbotChat.Data.Entity.Embedded;

import CoBo.ChatbotChat.Data.Entity.ChatRoom;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
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
public class ProfessorChatId implements Serializable {

    @ManyToOne
    private ChatRoom chatRoom;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
