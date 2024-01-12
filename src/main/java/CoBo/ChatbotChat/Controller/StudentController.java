package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final ChatService chatService;
}
