package CoBo.ChatbotChat.Controller;

import CoBo.ChatbotChat.Data.Dto.Chat.Req.StudentPostReq;
import CoBo.ChatbotChat.Data.Dto.Prof.Res.ProfStdGetRes;
import CoBo.ChatbotChat.Service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final ChatService chatService;

    @GetMapping
    @Operation(summary = "학생이 교수에게 한 질문 조회 API")
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
    public ResponseEntity<ProfStdGetRes> getStudent(@Valid @NotNull @Parameter(hidden = true) @RequestHeader("Authorization") String authorization) {
        return chatService.getStudent(authorization);
    }

    @PostMapping
    @Operation(summary = "학생이 교수에게 질문 작성")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공", content = @Content()),
            @ApiResponse(responseCode = "403", description = "인증 실패", content = @Content()),
            @ApiResponse(responseCode = "502", description = "데이터베이스에서 에러가 발생했습니다.\n관리자에게 문의해주세요.",
                    content = @Content()),
            @ApiResponse(responseCode = "504", description = "현재 데이터베이스에 연결할 수 없습니다.",
                    content = @Content())
    })
    public ResponseEntity<HttpStatus> postStudent(@RequestBody StudentPostReq studentPostReq, @Parameter(hidden = true) @RequestHeader("Authorization") String authorization){
        return chatService.postStudent(studentPostReq, authorization);
    }
}
