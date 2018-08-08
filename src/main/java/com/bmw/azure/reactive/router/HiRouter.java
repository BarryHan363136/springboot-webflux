package com.bmw.azure.reactive.router;

import com.bmw.azure.reactive.handler.HiHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 13:55
 */
@Slf4j
@Configuration
public class HiRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCity(HiHandler hiHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hi")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        hiHandler::Hi);
    }

}
