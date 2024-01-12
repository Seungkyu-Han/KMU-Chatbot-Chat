package CoBo.ChatbotChat.Service;

import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import org.springframework.http.ResponseEntity;

public interface ChatService {
    ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize);
}
