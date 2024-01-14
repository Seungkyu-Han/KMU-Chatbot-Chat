package CoBo.ChatbotChat.Service;

import CoBo.ChatbotChat.Data.Dto.Chat.Req.StudentPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Req.ProfPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfStdGetRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ChatService {

    ResponseEntity<ProfStdGetRes> get(Integer studentId);
    ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize);
    ResponseEntity<HttpStatus> post(ProfPostReq profPostReq);
    ResponseEntity<ProfStdGetRes> getStudent(String authorization);
    ResponseEntity<HttpStatus> postStudent(StudentPostReq studentPostReq, String authorization);
}
