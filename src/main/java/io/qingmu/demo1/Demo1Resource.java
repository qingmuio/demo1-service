package io.qingmu.demo1;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//@RefreshScope
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Demo1Resource {
    @Autowired
    private Demo2Client demo2Client;
    @Autowired
    private Config config;

    @GetMapping("hello")
    public User hello() {
        final String s = config.getDemo1Value() + " " + demo2Client.world();
        final User user = User.builder().date(new Date())
                .name(s)
                .build();
        return user;
    }

    @GetMapping("hello2")
    public DemoQueryModel hello2() {
        return demo2Client.hello2(DemoQueryModel.builder().nameEQ("world").build());
    }


    @PostMapping("/create")
    public UserCreateDto create(UserCreateDto userCreateDto) {
        return null;
    }

    @Data
    @Builder
    public static class User {
        private String name;
        private Date date;
    }
}
