package cn.edu.bupt.ch5_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cn.edu.bupt.ch5_2.AddController.isEmail;

@Controller
public class EditController {
    @RequestMapping("editcontact")
    public String gotoedit(HttpServletRequest request){

        return "edit";
    }
    @RequestMapping("editsubmit")
    public String toedit(@RequestParam("no") int no, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        int numofcontacts = (int)session.getAttribute("count") + 1;
        if(numofcontacts<no){
            return "contacts";
        }else{
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String qq = request.getParameter("qq");
            if(isEmail(email)&&name!=null&&phone!=null&&address!=null&&qq!=null){

                info newrecord = new info(name,phone,email,address,qq);

                info[] allrecords = null;
                allrecords = (info[])session.getAttribute("allrecords");
                allrecords[no-1] = newrecord;
                session.setAttribute("allrecords",allrecords);

            }else{
                return "edit";
            }


        }
        return "contacts";
    }
}
