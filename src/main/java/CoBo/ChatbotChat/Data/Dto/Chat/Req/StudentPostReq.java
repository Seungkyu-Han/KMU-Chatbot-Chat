package CoBo.ChatbotChat.Data.Dto.Chat.Req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentPostReq {
    @Schema(description = "학생이 작성할 질문", example = "한승규님의 나이가 궁금합니다.")
    private String comment;
}
