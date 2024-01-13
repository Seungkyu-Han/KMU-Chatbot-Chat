package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Data.Dto.Prof.Res.ChatGetRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import CoBo.ChatbotChat.Service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/prof")
@RequiredArgsConstructor
public class ProfController {

    private final ChatService chatService;

    @GetMapping("")
    @Operation(summary = "학생 질문 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공",
                    content = @Content()),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 대화입니다.",
                    content = @Content())
    })
    public ResponseEntity<ChatGetRes> get(@RequestParam("studentId") Integer studentId) {
        return chatService.get(studentId);
    }

    @GetMapping("/list")
    @Operation(summary = "학생들의 질문 리스트 조회 API", description = "학생들의 질문 리스트를 페이징으로 검색")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호", example = "0"),
            @Parameter(name = "pageSize", description = "한 페이지에 들어갈 질문의 개수", example = "20")
    })
    public ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize){
        return chatService.getList(page, pageSize);
    }
}
