package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Data.Dto.Prof.Req.ProfPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfStdGetRes;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfGetListRes;
import CoBo.ChatbotChat.Service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prof")
public class ProfController {

    private final ChatService chatService;

    @GetMapping
    @Operation(summary = "학생 질문 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공",
                    content = @Content()),
            @ApiResponse(responseCode = "403", description = "인증 실패",
                    content = @Content()),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 대화입니다.",
                    content = @Content()),
            @ApiResponse(responseCode = "502", description = "데이터베이스에서 에러가 발생했습니다.\n관리자에게 문의해주세요.",
                    content = @Content()),
            @ApiResponse(responseCode = "504", description = "현재 데이터베이스에 연결할 수 없습니다.",
                    content = @Content())
    })
    public ResponseEntity<ProfStdGetRes> get(@RequestParam Integer studentId) {
        return chatService.get(studentId);
    }

    @GetMapping("/list")
    @Operation(summary = "학생들의 질문 리스트 조회 API", description = "학생들의 질문 리스트를 페이징으로 검색")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호", example = "0"),
            @Parameter(name = "pageSize", description = "한 페이지에 들어갈 질문의 개수", example = "20")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공",
                    content = @Content()),
            @ApiResponse(responseCode = "403", description = "인증 실패",
                    content = @Content()),
            @ApiResponse(responseCode = "502", description = "데이터베이스에서 에러가 발생했습니다.\n관리자에게 문의해주세요.",
                    content = @Content()),
            @ApiResponse(responseCode = "504", description = "현재 데이터베이스에 연결할 수 없습니다.",
                    content = @Content())
    })
    public ResponseEntity<ProfGetListRes> getList(Integer page, Integer pageSize){
        return chatService.getList(page, pageSize);
    }

    @PostMapping
    @Operation(summary = "교수의 답변 작성 API", description = "교수가 학생의 질문에 대한 답변을 작성함")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공",
                    content = @Content()),
            @ApiResponse(responseCode = "403", description = "인증 실패",
                    content = @Content()),
            @ApiResponse(responseCode = "502", description = "데이터베이스에서 에러가 발생했습니다.\n관리자에게 문의해주세요.",
                    content = @Content()),
            @ApiResponse(responseCode = "504", description = "현재 데이터베이스에 연결할 수 없습니다.",
                    content = @Content())
    })
    public ResponseEntity<HttpStatus> post(@RequestBody ProfPostReq profPostReq){
        return chatService.post(profPostReq);
    }
}
