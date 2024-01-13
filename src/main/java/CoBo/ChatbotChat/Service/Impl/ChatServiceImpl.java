package CoBo.ChatbotChat.Service.Impl;

import CoBo.ChatbotChat.Data.Dto.Prof.Req.ProfPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetElementRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import CoBo.ChatbotChat.Data.Entity.ProfessorChat;
import CoBo.ChatbotChat.Data.Enum.ChatStateEnum;
import CoBo.ChatbotChat.Repository.ChatRoomRepository;
import CoBo.ChatbotChat.Repository.ProfessorChatRepository;
import CoBo.ChatbotChat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ProfessorChatRepository professorChatRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ResponseEntity<ChatGetRes> get(Integer studentId) {

        List<ProfessorChat> professorChatList = professorChatRepository.findByStudentId(studentId);
        chatRoomRepository.updateStateById(studentId, ChatStateEnum.CONFIRMATION.ordinal());

        ArrayList<ChatGetElementRes> chatGetElementResList = new ArrayList<>();

        for (ProfessorChat professorChat : professorChatList)
            chatGetElementResList.add(new ChatGetElementRes(professorChat));

        return new ResponseEntity<>(new ChatGetRes(chatGetElementResList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize) {
        return new ResponseEntity<>(
                new ProfGetListRes(chatRoomRepository.count(), chatRoomRepository.findWithLastChatByPaging(page, pageSize)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> post(ProfPostReq profPostReq) {

        professorChatRepository.insertProfessorChat(profPostReq.getStudentId(), profPostReq.getComment(), false);
        chatRoomRepository.updateStateById(profPostReq.getStudentId(), ChatStateEnum.COMPLETE.ordinal());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
