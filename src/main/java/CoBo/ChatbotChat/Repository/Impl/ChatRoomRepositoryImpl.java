package CoBo.ChatbotChat.Repository.Impl;

import CoBo.ChatbotChat.Data.Dao.Chat.ChatRoomDao;
import CoBo.ChatbotChat.Repository.Custom.ChatRoomRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Slf4j
public class ChatRoomRepositoryImpl implements ChatRoomRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ChatRoomDao> findWithLastChatByPaging(Integer page, Integer pageSize) {
        String sql = "SELECT cr.student_id, cr.name, cr.state, pc.comment, pc.created_at FROM chat_room cr " +
                "JOIN professor_chat pc on cr.student_id = pc.chat_room_student_id " +
                "WHERE pc.id = (" +
                "SELECT MAX(id) FROM professor_chat WHERE pc.chat_room_student_id = cr.student_id" +
                ") " +
                "ORDER BY state, student_id LIMIT ?, ?";
        return jdbcTemplate.query(sql,
                (resultSet, count) ->
                        new ChatRoomDao(
                                resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getTimestamp(5)
                        ), page, pageSize);
    }
}
