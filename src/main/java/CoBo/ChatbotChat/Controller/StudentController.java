package CoBo.ChatbotChat.Controller;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final ChatService chatService;

    @GetMapping
    @Operation(summary = "학생이 교수에게 한 질문 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공",
                    content = @Content()),
            @ApiResponse(responseCode = "403", description = "인증 실패",
                    content = @Content())
    })
    public ResponseEntity<ProfStdGetRes> getStudent(@Valid @NotNull @Parameter(hidden = true) @RequestHeader("Authorization") String authorization) {
        return chatService.getStudent(authorization);
    }
}
