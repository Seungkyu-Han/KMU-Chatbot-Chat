package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.ChatRoom;
import CoBo.ChatbotChat.Repository.Custom.ChatRoomRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer>, ChatRoomRepositoryCustom {
}
