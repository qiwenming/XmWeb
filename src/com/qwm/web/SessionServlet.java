package com.qwm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * qiwenming
 */
@WebServlet(name = "SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

       HttpSession session = request.getSession();

        if(session.isNew()){
            response.getWriter().println("新创建的:"+session.getId());
        }else{
            response.getWriter().println("已经存在:"+session.getId());
        }
        System.out.println("我看看能打印到控制台不");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
