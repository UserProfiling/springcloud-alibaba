package org.kehl.nacosConfig.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    @Value("${user.config}")
    String Config;

    @RequestMapping("getConfig")
    public String getConfig(){
        return Config;
    }

}
