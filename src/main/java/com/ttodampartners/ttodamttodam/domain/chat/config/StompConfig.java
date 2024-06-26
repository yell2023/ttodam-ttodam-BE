package com.ttodampartners.ttodamttodam.domain.chat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
    Stomp를 사용하기 위한 설정 파일
*/

@RequiredArgsConstructor
@EnableWebSocketMessageBroker
@Configuration
public class StompConfig implements WebSocketMessageBrokerConfigurer {
    private final StompHandler stompHandler;
    private final StompExceptionHandler stompExceptionHandler;

    // Stomp 연결을 처리할 엔드포인트
    @Override
    public void registerStompEndpoints (StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-chatting").setAllowedOriginPatterns("*");
        /*
         WebSocket 연결 시 요청을 보낼 EndPoint 경로 -> ws://localhost:8080/ws-chatting
         setAllowedOrigins("*")은 CORS 이슈를 피하기 위함; 배포 때는 * 대신 실제 서버 주소 등록
         맨마지막에 .withSockJS() 추가 필요
        */
        registry.setErrorHandler(stompExceptionHandler);
    }

    // 메시지를 처리할 엔드포인트
    @Override
    public void configureMessageBroker (MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/chatroom"); // sub: 메시지 브로커가 Subscriber들에게 메시지를 전달할 URL 접두사
        registry.setApplicationDestinationPrefixes("/chattings"); // pub: 클라이언트가 서버로 메시지 보낼 URL 접두사
    }

    // 메시지를 Controller로 보내기 전 JWT 유효성 검사
    @Override
    public void configureClientInboundChannel (ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }
}
