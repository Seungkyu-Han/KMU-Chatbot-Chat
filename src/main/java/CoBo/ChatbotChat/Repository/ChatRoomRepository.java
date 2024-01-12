package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
}
