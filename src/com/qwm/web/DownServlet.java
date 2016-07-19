package com.qwm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by hunlisong on 16/7/14.
 */
@WebServlet(name = "DownServlet")
public class DownServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        downloadFileByBytes(request,response);
    }

    /**
     * 下载
     * @param request
     * @param response
     */
    private void downloadFileByBytes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取文件路径
        //2.获取文件名
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件
        //4.获取需要下载的文件流
        //5.创建数据缓冲区
        //6.获取输出流
        //7.读数据到缓冲区
        //8.写数据
        String realName = getServletContext().getRealPath("/myfile/xm.txt");
        String fileName = realName.substring(realName.lastIndexOf("/")+1);
        response.setHeader("content-disposition","attachment;filename="+fileName);
        InputStream in = new FileInputStream(realName);
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = response.getOutputStream();
        while( (len=in.read(buffer)) >0){
            out.write(buffer,0,len);
        }
        out.flush();
        in.close();
    }


}
