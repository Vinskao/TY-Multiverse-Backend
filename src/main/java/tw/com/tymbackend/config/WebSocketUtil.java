package tw.com.tymbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import jakarta.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketUtil 負責配置 WebSocket 和 STOMP 端點。
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketUtil implements WebSocketMessageBrokerConfigurer {

    private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    // 新增紀錄Session
    public static void addSession(String userNick, Session session) {
        ONLINE_SESSION.put(userNick, session);
    }

    // 移除Session
    public static void remoteSession(String userNick) {
        ONLINE_SESSION.remove(userNick);
    }

    // 發送訊息
    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }
        session.getAsyncRemote().sendText(message);
    }

    // 發送群體訊息
    public static void sendMessageForAll(String message) {
        ONLINE_SESSION.forEach((sessionId, session) -> sendMessage(session, message));
    }

    /**
     * 配置消息代理。
     *
     * @param config 用於配置消息代理的 MessageBrokerRegistry 實例
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 註冊 STOMP 端點。
     *
     * @param registry 用於註冊 STOMP 端點的 StompEndpointRegistry 實例
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/metrics").setAllowedOriginPatterns("*");
    }
} 