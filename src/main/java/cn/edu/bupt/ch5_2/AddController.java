package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AddController {
    @RequestMapping("addcontact")
    public String TryLogin(HttpServletRequest request){
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");

        if(isEmail(email)&&name!=null&&phone!=null&&address!=null&&qq!=null){
            //添加到session
            HttpSession session = request.getSession(true);
            Integer count = (Integer)session.getAttribute("count");
            System.out.println(count);

            info newrecord = new info(name,phone,email,address,qq);
            info[] allrecords = null;
            allrecords = (info[])session.getAttribute("allrecords");
            allrecords[count+1] = newrecord;

            String[] names= null;
            names = (String[])session.getAttribute("names");
            names[count+1] = name;

            String[] phones= null;
            phones = (String[])session.getAttribute("phones");
            phones[count+1] = name;

            String[] emails= null;
            emails = (String[])session.getAttribute("emails");
            emails[count+1] = name;

            String[] addresses= null;
            addresses = (String[])session.getAttribute("addresses");
            addresses[count+1] = name;

            String[] qqs= null;
            qqs = (String[])session.getAttribute("qqs");
            qqs[count+1] = name;

            count=count+1;
            session.setAttribute("allrecords",allrecords);
            session.setAttribute("names",names);
            session.setAttribute("phones",phones);
            session.setAttribute("emails",emails);
            session.setAttribute("addresses",addresses);
            session.setAttribute("qqs",qqs);
            session.setAttribute("count",count);

            for(int i=0;i<=count ;i=i+1){
                System.out.println(names[i]);
            }

            return "contacts";
        }else{
            return "add";
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
    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }

}
