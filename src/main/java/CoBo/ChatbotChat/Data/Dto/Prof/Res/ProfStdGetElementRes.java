package CoBo.ChatbotChat.Data.Dto.Prof.Res;

import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfStdGetElementRes {

    String comment;

    LocalDateTime time;

    Boolean isQuestion;

    public ProfStdGetElementRes(ProfessorChat professorChat) {
        this.comment = professorChat.getComment();
        this.time = professorChat.getCreatedAt();
        this.isQuestion = professorChat.getQuestion();
    }
}
