package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CheckController {
    @PostMapping("/check")
    public String TryLogin(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if((username.equals("admin")&&password.equals("123456"))){



            System.out.println("check!");
            HttpSession session = request.getSession(true);
            info[] allrecords = null;
            String[] names = null;
            String[] phones = null;
            String[] emails = null;
            String[] addresses = null;
            String[] qqs = null;
            allrecords = new info[20];
            System.out.println("check!");
            names = new String[20];
            phones = new String[20];
            emails = new String[20];
            addresses = new String[20];
            qqs = new String[20];

            session.setAttribute("allrecords",allrecords);
            System.out.println("check!");
            session.setAttribute("names",names);
            session.setAttribute("phones",phones);
            session.setAttribute("emails",emails);
            session.setAttribute("addresses",addresses);
            session.setAttribute("qqs",qqs);


            Integer count = -1;
            session.setAttribute("count",count);

            session.setAttribute("sessionid",session.getId());

            return "contacts";
        }else{
            return "login";
        }

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
