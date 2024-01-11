package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.ChatbotChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatbotChatRepository extends JpaRepository<ChatbotChat, Integer> {
}
