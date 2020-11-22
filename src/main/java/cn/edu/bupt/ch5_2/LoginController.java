package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String TryLogin(HttpServletRequest request){
        return "login";
        /*HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(session.getAttribute("loginstatus").equals("true")||(username.equals("admin")&&password.equals("123456"))){
            return "login";
        }else{
            return "login";
        }*/
    }
}
