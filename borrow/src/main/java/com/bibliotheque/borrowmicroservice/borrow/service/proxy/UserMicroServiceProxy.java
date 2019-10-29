package com.bibliotheque.borrowmicroservice.borrow.service.proxy;

import com.bibliotheque.borrowmicroservice.borrow.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "com.bibliotheque.usermicroservice", url = "localhost:9040")

public interface UserMicroServiceProxy {

    @RequestMapping(value = "/api/user/getUser", method = RequestMethod.GET)
    User getUser(String id);

}
