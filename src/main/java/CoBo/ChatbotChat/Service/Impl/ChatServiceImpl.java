package CoBo.ChatbotChat.Service.Impl;

import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import CoBo.ChatbotChat.Repository.ChatRoomRepository;
import CoBo.ChatbotChat.Repository.ProfessorChatRepository;
import CoBo.ChatbotChat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final ProfessorChatRepository professorChatRepository;

    @Override
    public ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize) {
        return new ResponseEntity<>(
                new ProfGetListRes(chatRoomRepository.count(), chatRoomRepository.findWithLastChatByPaging(page, pageSize)), HttpStatus.OK);
    }
}
