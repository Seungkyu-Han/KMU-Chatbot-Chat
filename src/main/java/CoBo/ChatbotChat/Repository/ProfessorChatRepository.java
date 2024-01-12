package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.Embedded.ProfessorChatId;
import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorChatRepository extends JpaRepository<ProfessorChat, ProfessorChatId> {
}
