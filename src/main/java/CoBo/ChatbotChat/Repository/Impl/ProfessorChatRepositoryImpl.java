package CoBo.ChatbotChat.Repository.Impl;

import CoBo.ChatbotChat.Repository.Custom.ProfessorChatRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProfessorChatRepositoryImpl implements ProfessorChatRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertProfessorChat(Integer studentId, String comment, boolean question) {
        String sql = "INSERT INTO professor_chat (chat_room_student_id, comment, question) VALUES (?, ?, ?) ";
        jdbcTemplate.update(sql, studentId, comment, question);
    }
}
