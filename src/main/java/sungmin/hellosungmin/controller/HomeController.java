package sungmin.hellosungmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //요청이오면 컨트롤러에서 찾아보고 없으면 정적파일을 뒤진다.
    @GetMapping("/")
    public  String home(){
        return "home";
    }
}
