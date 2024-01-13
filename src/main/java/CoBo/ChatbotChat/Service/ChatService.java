package CoBo.ChatbotChat.Service;

import CoBo.ChatbotChat.Data.Dto.Prof.Req.ProfPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ChatService {

    ResponseEntity<ChatGetRes> get(Integer studentId);
    ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize);
    ResponseEntity<HttpStatus> post(ProfPostReq profPostReq);
}
