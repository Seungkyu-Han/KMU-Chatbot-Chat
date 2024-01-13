package CoBo.ChatbotChat.Service.Impl;

import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetElementRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetRes;
import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import CoBo.ChatbotChat.Data.Enum.ChatStateEnum;
import CoBo.ChatbotChat.Repository.ProfessorChatRepository;
import CoBo.ChatbotChat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ProfessorChatRepository professorChatRepository;

    @Override
    public ResponseEntity<ChatGetRes> get(Integer studentId) {

        List<ProfessorChat> professorChatList = professorChatRepository.findByStudentId(studentId);

        if (professorChatList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        ArrayList<ChatGetElementRes> chatGetElementResList = new ArrayList<>();

        for (ProfessorChat professorChat : professorChatList) {
            chatGetElementResList.add(new ChatGetElementRes(
                    professorChat.getComment(),
                    professorChat.getCreatedAt(),
                    ChatStateEnum.CONFIRMATION
            ));
        }

        return new ResponseEntity<>(new ChatGetRes(chatGetElementResList), HttpStatus.OK);
    }
}
