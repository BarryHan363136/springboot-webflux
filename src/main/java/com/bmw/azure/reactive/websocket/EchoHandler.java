package com.bmw.azure.reactive.websocket;

import com.bmw.azure.reactive.common.utils.JSONMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 18:11
 *
 * WebFlux WebSocket 参考文档: https://www.ibm.com/developerworks/cn/java/spring5-webflux-reactive/
 * 运行应用之后，可以使用工具来测试该 WebSocket 服务。打开工具页面 https://www.websocket.org/echo.html，
 * 然后连接到 ws://localhost:8096/echo，可以发送消息并查看服务器端返回的结果。
 *
 */
@Slf4j
@Component
public class EchoHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(final WebSocketSession session) {
        Flux<WebSocketMessage> wsmsg = session.receive();
        log.info("=================>WebSocket服务的接收到客户端发送过来的消息为:"+JSONMapper.writeObjectAsString(wsmsg));
        return session.send(
                session.receive()
                        .map(msg -> session.textMessage("ECHO -> " + msg.getPayloadAsText())));
    }

}