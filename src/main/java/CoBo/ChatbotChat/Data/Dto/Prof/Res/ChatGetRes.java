package CoBo.ChatbotChat.Data.Dto.Prof.Res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatGetRes {

    List<ChatGetElementRes> chatGetElementResList;
}
