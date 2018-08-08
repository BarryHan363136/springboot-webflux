package com.bmw.azure.reactive.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 13:45
 */
@Slf4j
@Component
public class HiHandler {


    public Mono<ServerResponse> Hi(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("Hi , this is SpringWebFlux"));
    }
}