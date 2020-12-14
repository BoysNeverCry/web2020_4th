package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@RestController
public class CheckPN {

        @RequestMapping("/CheckPN")
        public String TryLogin(HttpServletRequest request){
            HttpSession session = request.getSession(true);
            Integer count = (Integer)session.getAttribute("count");

            info[] allrecords = null;
            allrecords = (info[])session.getAttribute("allrecords");
            System.out.println("count="+count);
            for(int i=0;i<=count ;i=i+1){
                System.out.println(allrecords[i].phone);
                System.out.println(request.getParameter("number"));
                if(request.getParameter("number").equals(allrecords[i].phone))
                    return "Phone number already exists!";
            }

            return "Correct, this is a unique phone number.";
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
