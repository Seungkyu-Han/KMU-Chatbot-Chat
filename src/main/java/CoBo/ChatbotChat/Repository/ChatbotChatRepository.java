package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.ChatbotChat;
import CoBo.ChatbotChat.Data.Entity.Embedded.ChatbotChatId;
import CoBo.ChatbotChat.Repository.Custom.ChatbotChatRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotChatRepository extends JpaRepository<ChatbotChat, ChatbotChatId>, ChatbotChatRepositoryCustom {
}
