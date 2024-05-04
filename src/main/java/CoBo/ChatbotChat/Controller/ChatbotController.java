package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Service.ChatbotService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController("/api/chatbot")
@RequiredArgsConstructor
@Slf4j
public class ChatbotController {

    private final ChatbotService chatbotService;

    @GetMapping("/api/chat")
    public ResponseEntity<String> getChat(@RequestParam String question, @Parameter(hidden = true)Authentication authentication){
        return chatbotService.getChat(question, authentication);
    }
}
