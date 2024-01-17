package CoBo.ChatbotChat.Service;

import org.springframework.http.ResponseEntity;

public interface ChatbotService {
    ResponseEntity<String> getChat(String question);
}
