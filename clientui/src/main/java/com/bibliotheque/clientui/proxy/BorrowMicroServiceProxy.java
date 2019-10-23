package com.bibliotheque.clientui.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "com.bibliotheque.borrowmicroservice", url = "localhost:9020")
public interface BorrowMicroServiceProxy {
}
