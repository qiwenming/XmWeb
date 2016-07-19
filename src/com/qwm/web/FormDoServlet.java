package com.qwm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * qiwenming
 */
@WebServlet(name = "FormServlet")
public class FormDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        if(isRepeatSubmit(request)){
            response.getWriter().println("重复提交了");
            System.out.println("重复提交");
            return;
        }
        response.getWriter().println("提交处理中--->");
        System.out.println("处理提交");
        request.getSession().removeAttribute("token");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return
     *         true 用户重复提交了表单
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }

        return false;
    }
}

