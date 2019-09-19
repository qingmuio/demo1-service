package io.qingmu.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo1Resource {

    @Autowired
    private Demo2Client demo2Client;

    @Value("${demo1Value}")
    private String demo1Value;

    @GetMapping("hello")
    public String hello() {
        return demo1Value + " " + demo2Client.world();
    }

    @GetMapping("hello2")
    public DemoQueryModel hello2() {
        return demo2Client.hello2(DemoQueryModel.builder().nameEQ("world").build());
    }


}
