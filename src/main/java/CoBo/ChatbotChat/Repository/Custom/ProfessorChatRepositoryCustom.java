package CoBo.ChatbotChat.Repository.Custom;

public interface ProfessorChatRepositoryCustom {
    void insertProfessorChat(Integer studentId, String comment, boolean question);
}
