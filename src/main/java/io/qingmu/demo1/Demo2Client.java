package io.qingmu.demo1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("demo2-service")
public interface Demo2Client {

    @GetMapping("/world")
    String world();

    @GetMapping("world2")
    DemoQueryModel hello2(@SpringQueryMap DemoQueryModel demo);
}
