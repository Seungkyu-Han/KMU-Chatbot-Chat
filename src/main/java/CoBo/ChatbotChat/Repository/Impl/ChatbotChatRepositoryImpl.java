package CoBo.ChatbotChat.Repository.Impl;

import CoBo.ChatbotChat.Repository.Custom.ChatbotChatRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ChatbotChatRepositoryImpl implements ChatbotChatRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insert(Integer chat_room_student_id, String question, String answer) {
        String sql = "INSERT INTO chatbot_chat (student_id, question, answer) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, chat_room_student_id, question, answer);
    }
}
