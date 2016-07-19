package com.qwm.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/***
 * qiwenming
 */
public class CookieServlet extends HttpServlet{

    private static final String lastTime = "lastTime";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        StringBuilder sb = new StringBuilder("\n");

        //获取cookie
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals(lastTime)){
                    //获取上一次的时间并且打印
                    Long lastTimeLong = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastTimeLong);
                    out.write(date.toLocaleString());
                }

                sb.append(cookie.getName()+" : "+cookie.getValue()+"\n");

            }
        }else{
            out.println("第一次访问哦:");
            out.flush();
        }
        out.println(sb.toString());
        Cookie cookie = new Cookie(lastTime,System.currentTimeMillis()+"");
        resp.addCookie(cookie);
    }
}
