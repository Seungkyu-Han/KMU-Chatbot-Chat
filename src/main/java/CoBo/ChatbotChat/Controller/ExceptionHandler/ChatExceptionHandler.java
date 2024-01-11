package CoBo.ChatbotChat.Controller.ExceptionHandler;

import CoBo.ChatbotChat.Controller.ChatController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ChatController.class)
public class ChatExceptionHandler {
}
