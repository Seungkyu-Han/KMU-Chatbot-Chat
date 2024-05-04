package CoBo.ChatbotChat.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface ChatbotService {
    ResponseEntity<String> getChat(String question, Authentication authentication);
}
