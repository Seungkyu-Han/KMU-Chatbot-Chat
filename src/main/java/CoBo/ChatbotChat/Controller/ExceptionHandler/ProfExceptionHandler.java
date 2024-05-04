package CoBo.ChatbotChat.Controller.ExceptionHandler;

import CoBo.ChatbotChat.Controller.ProfController;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = ProfController.class)
public class ProfExceptionHandler {

    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ResponseEntity<String> CannotGetJdbcConnectionExceptionHandler(){
        return new ResponseEntity<>("현재 데이터베이스에 연결할 수 없습니다.", HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> DataAccessExceptionHandler(){
        return new ResponseEntity<>("데이터베이스에서 에러가 발생했습니다.\n관리자에게 문의해주세요.", HttpStatus.BAD_GATEWAY);
    }
}
