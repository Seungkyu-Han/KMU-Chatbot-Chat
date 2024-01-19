package CoBo.ChatbotChat.Data.Dto.Prof.Req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProfPostReq {
    @Schema(description = "답변을 작성할 학생의 학번", example = "2019112785")
    private Integer studentId;
    @Schema(description = "작성할 답변", example = "킹승규 화이팅")
    private String comment;
}
