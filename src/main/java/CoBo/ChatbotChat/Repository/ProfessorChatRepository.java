package CoBo.ChatbotChat.Repository;

import CoBo.ChatbotChat.Data.Entity.Embedded.ProfessorChatId;
import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import CoBo.ChatbotChat.Repository.Custom.ProfessorChatRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorChatRepository extends JpaRepository<ProfessorChat, ProfessorChatId>, ProfessorChatRepositoryCustom {

    @Query("SELECT pc FROM ProfessorChat pc " +
            "WHERE pc.professorChatId.chatRoom.studentId = :studentId")
    List<ProfessorChat> findByStudentId(Integer studentId);
}
