package io.qingmu.demo1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@Data
public class Config {

    @Value("${demo1Value}")
    private String demo1Value;
}
