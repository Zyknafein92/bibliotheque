package com.bibliotheque.borrowmicroservice.borrow.service.proxy;

import com.bibliotheque.borrowmicroservice.borrow.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "com.bibliotheque.usermicroservice", url = "localhost:9040")

public interface UserMicroServiceProxy {

    @RequestMapping(value = "/api/user/getUser", method = RequestMethod.GET)
    User getUser(String id);

    // TODO: 29/10/2019 : setAvaible();

}
