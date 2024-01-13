package CoBo.ChatbotChat.Data.Dto.Prof.Res;

import CoBo.ChatbotChat.Data.Dao.Chat.ChatRoomDao;
import lombok.Data;

import java.util.List;

@Data
public class ProfGetListRes {

    private Long questionCount;

    private List<ChatRoomDao> chatRoomDaoList;

    public ProfGetListRes(Long questionCount, List<ChatRoomDao> chatRoomDaoList) {
        this.questionCount = questionCount;
        this.chatRoomDaoList = chatRoomDaoList;
    }
}
