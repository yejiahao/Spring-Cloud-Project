package org.yejh.bootdemo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {
    @RequestMapping("/hw")
    public String aaa() {
        return "Hello, World";
    }
}
