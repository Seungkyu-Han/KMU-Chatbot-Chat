package CoBo.ChatbotChat.Data.Dto.Prof.Res;

import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatGetElementRes {

    String comment;

    LocalDateTime time;

    Boolean isQuestion;

    public ChatGetElementRes(ProfessorChat professorChat) {
        this.comment = professorChat.getComment();
        this.time = professorChat.getCreatedAt();
        this.isQuestion = professorChat.getQuestion();
    }
}
