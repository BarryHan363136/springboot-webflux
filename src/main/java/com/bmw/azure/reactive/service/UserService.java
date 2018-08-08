package com.bmw.azure.reactive.service;

import com.bmw.azure.reactive.entity.User;
import com.bmw.azure.reactive.exception.ResourceNotFoundException;
import com.sun.org.apache.xml.internal.security.signature.MissingResourceFailureException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 16:39
 */
@Service
public class UserService {

    private final Map<String, User> data = new ConcurrentHashMap<>();

    public Flux<User> list(){
        return Flux.fromIterable(this.data.values());
    }

    public Flux<User> getById(final Flux<String> ids){
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    public Mono<User> getById(final String id){
        return Mono.justOrEmpty(this.data.get(id)).
                switchIfEmpty(Mono.error(new ResourceNotFoundException()));
    }

    public Mono<User> createOrUpdate(final User user){
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> delete(String id){
        return Mono.justOrEmpty(this.data.remove(id));
    }



}
