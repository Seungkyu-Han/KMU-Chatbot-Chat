package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.ChatbotChat;
import CoBo.ChatbotChat.Data.Entity.Embedded.ChatbotChatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotChatRepository extends JpaRepository<ChatbotChat, ChatbotChatId> {
}
