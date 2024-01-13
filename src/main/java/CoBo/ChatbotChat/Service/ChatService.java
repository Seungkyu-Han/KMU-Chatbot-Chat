package CoBo.ChatbotChat.Service;

import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetRes;
import org.springframework.http.ResponseEntity;

public interface ChatService {

    ResponseEntity<ChatGetRes> get(Integer studentId);
}
