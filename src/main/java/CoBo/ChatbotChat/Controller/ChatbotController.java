package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/chatbot")
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;
}
