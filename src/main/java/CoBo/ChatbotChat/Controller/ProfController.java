package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/prof")
@RequiredArgsConstructor
public class ProfController {

    private final ChatService chatService;
}
