package CoBo.ChatbotChat.Repository.Impl;

import CoBo.ChatbotChat.Data.Dao.Chat.ChatRoomDao;
import CoBo.ChatbotChat.Repository.Custom.ChatRoomRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
                "WHERE (pc.id, pc.chat_room_student_id) in (" +
                "SELECT MAX(id), chat_room_student_id FROM professor_chat group by chat_room_student_id)" +
                "ORDER BY state, pc.created_at desc LIMIT ?, ?";
        return jdbcTemplate.query(sql,
                (resultSet, count) ->
                        new ChatRoomDao(
                                resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getTimestamp(5)
                        ), page, pageSize);
    }

    @Override
    @Transactional
    public void updateStateById(Integer studentId, int state) {
        String sql = "UPDATE chat_room SET state = ? WHERE student_id = ?";
        jdbcTemplate.update(sql, state, studentId);
    }

    @Override
    public void updateStateByIdAndState(Integer studentId, int cur_state, int change_state) {
        String sql = "UPDATE chat_room SET state = ? WHERE student_id = ? and state = ?";
        jdbcTemplate.update(sql, change_state, studentId, cur_state);
    }

    @Override
    @Transactional
    public void updateIfExistElseInsert(Integer studentId, int state, String name) {
        String sql = "INSERT INTO chat_room (student_id, state, name) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE state = ?, name = ?";
        jdbcTemplate.update(sql, studentId, state, name, state, name);
    }
}
