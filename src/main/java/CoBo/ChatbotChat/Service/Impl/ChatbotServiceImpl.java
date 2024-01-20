package CoBo.ChatbotChat.Service.Impl;

import CoBo.ChatbotChat.Repository.ChatbotChatRepository;
import CoBo.ChatbotChat.Service.ChatbotService;
import com.google.cloud.dialogflow.v2.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatbotServiceImpl implements ChatbotService {

    private final ChatbotChatRepository chatbotChatRepository;

    private static int sessionId = 0;

    @Value("${dialogFlow.projectId}")
    private String projectId;

    @Override
    public ResponseEntity<String> getChat(String question, Authentication authentication) {
        try(SessionsClient sessionsClient = SessionsClient.create()){

            SessionName sessionName = SessionName.of(projectId, String.valueOf(sessionId++));

            TextInput.Builder textInput =
                    TextInput.newBuilder().setText(question).setLanguageCode("ko");

            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

            DetectIntentResponse response = sessionsClient.detectIntent(sessionName, queryInput);

            chatbotChatRepository.insert(Integer.valueOf(authentication.getName()) ,question, response.getQueryResult().getFulfillmentText());

            return new ResponseEntity<>(response.getQueryResult().getFulfillmentText(), HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
