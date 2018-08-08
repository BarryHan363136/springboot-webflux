package com.bmw.azure.reactive.service;

import com.bmw.azure.reactive.common.utils.JSONMapper;
import com.bmw.azure.reactive.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author Tongshan.Han@partner.bmw.com
 * @Description:
 * @date 2018/8/8 17:34
 */
@Slf4j
public class UserServiceTest {

    @Test
    public void testSerializable(){
        User user = new User();
        user.setId("100");
        user.setName("zhangsan");
        user.setEmail("lxm@bmw.com");
        log.info("================>"+JSONMapper.writeObjectAsString(user));
    }

}
