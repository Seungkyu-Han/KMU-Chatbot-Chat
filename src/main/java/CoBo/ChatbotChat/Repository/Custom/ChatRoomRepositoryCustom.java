package CoBo.ChatbotChat.Repository.Custom;

import CoBo.ChatbotChat.Data.Dao.Chat.ChatRoomDao;

import java.util.List;

public interface ChatRoomRepositoryCustom {

    List<ChatRoomDao> findWithLastChatByPaging(Integer page, Integer pageSize);

    void updateStateById(Integer studentId, int state);

    void updateIfExistElseInsert(Integer studentId, int state);

    void updateStateByIdAndState(Integer studentId, int cur_state, int change_state);
}
