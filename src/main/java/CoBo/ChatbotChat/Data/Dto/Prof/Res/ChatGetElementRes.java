package CoBo.ChatbotChat.Data.Dto.Prof.Res;

import CoBo.ChatbotChat.Data.Enum.ChatStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGetElementRes {

    String comment;

    LocalDateTime time;

    ChatStateEnum state;
}
