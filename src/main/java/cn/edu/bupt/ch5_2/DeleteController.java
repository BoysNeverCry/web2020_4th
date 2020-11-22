package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeleteController {
    @RequestMapping("deletecontact")
    public String todelete(@RequestParam("no") int no, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        int numofcontacts = (int)session.getAttribute("count") + 1;
        if(no>numofcontacts){

        }else{
            int newcount = numofcontacts - 2;
            info[] allrecords = null;
            allrecords = (info[])session.getAttribute("allrecords");
            for(int i=no-1;i<=newcount;i++){
                allrecords[i] = allrecords[i+1];
            }

            session.setAttribute("count",newcount);
            session.setAttribute("allrecords",allrecords);

        }
        return "contacts";
    }
}
