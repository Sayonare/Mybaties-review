package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wyz_Sayonare on 2017/10/7.
 */
@Controller
public class TestController {


    @RequestMapping("/test")
    public String goTest(HttpServletRequest request)
    {
        System.out.println(request.getRequestURI());
        return "index";
    }


}
