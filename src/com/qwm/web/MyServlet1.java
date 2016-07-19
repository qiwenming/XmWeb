package com.qwm.web;

import sun.net.www.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/***
 * qiwenming
 */
@WebServlet(name = "MyServlet1")
public class MyServlet1 extends HttpServlet {

    private String url = "http://test.api.u-thin.com/account/level/list?platform=2&deviceId=3f0fe74b555ff95d563a2cfe3cb9c834&unixTime=1468444336801&signature=0ce0d8609793af35f73ccde3728d01600ee667e5495480c17c1855be0bef1676&token=41cd989be0ccc5e034df21b2653edf23bf244c25&version=1000002&channel=nochannel&os=6.0&model=Android_Custom+Phone+-+6.0.0+-+API+23+-+768x1280";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long time = System.currentTimeMillis();
        printInfo(request,response);
//        for (int i = 0; i < 20; i++) {
//            String msg = sendGet(url,null);
//            response.getWriter().println("\n============================="+i+"==================================");
//            response.getWriter().println(msg);
//        }
//        response.getWriter().println("\n\n\n <html><font size='5' color='red'>"+(System.currentTimeMillis()-time)+"ms</font>  </html>\n\n\n");
//        response.getWriter().flush();
    }


    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            String full_url = url;
            if(parameters!=null) {
                // 编码请求参数
                if (parameters.size() == 1) {
                    for (String name : parameters.keySet()) {
                        sb.append(name).append("=").append(
                                java.net.URLEncoder.encode(parameters.get(name),
                                        "UTF-8"));
                    }
                    params = sb.toString();
                } else {
                    for (String name : parameters.keySet()) {
                        sb.append(name).append("=").append(
                                java.net.URLEncoder.encode(parameters.get(name),
                                        "UTF-8")).append("&");
                    }
                    String temp_params = sb.toString();
                    params = temp_params.substring(0, temp_params.length() - 1);
                }
                full_url = full_url+ "?" + params;
            }

            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


    public void printInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //        response.getWriter().println("ip:"+request.getRemoteHost());
//        response.getWriter().print(sendGet("http://www.baidu.com",null));
        response.getWriter().println("===========================================>>>>");
        response.getWriter().println("getAuthType() : "+request.getAuthType());
//        response.getWriter().println("getAsyncContext() : "+request.getAsyncContext());
        response.getWriter().println("getAttributeNames() : "+request.getAttributeNames());

        response.getWriter().println("getContextPath() : "+request.getContextPath());
        response.getWriter().println("getCharacterEncoding() : "+request.getCharacterEncoding());
        response.getWriter().println("getContentType() : "+request.getContentType());
        response.getWriter().println("getCookies() : "+request.getCookies());
        response.getWriter().println("getContentLength() : "+request.getContentLength());

        response.getWriter().println("getDispatcherType() : "+request.getDispatcherType());

        response.getWriter().println("getHeaderNames() : "+request.getHeaderNames());

        response.getWriter().println("getLocalAddr() : "+request.getLocalAddr());
        response.getWriter().println("getLocalName() : "+request.getLocalName());
        response.getWriter().println("getLocale() : "+request.getLocale());
        response.getWriter().println("getLocales() : "+request.getLocales());
        response.getWriter().println("getLocalPort() : "+request.getLocalPort());

        response.getWriter().println("getMapping() : "+request.getMapping());

        response.getWriter().println("getPathInfo() : "+request.getPathInfo());
        response.getWriter().println("getPathTranslated() : "+request.getPathTranslated());
        response.getWriter().println("getProtocol() : "+request.getProtocol());
//        response.getWriter().println("getParts() : "+request.getParts());
        response.getWriter().println("getPushBuilder() : "+request.getPushBuilder());

        response.getWriter().println("getRemoteUser() : "+request.getRemoteUser());
        response.getWriter().println("getRequestedSessionId() : "+request.getRequestedSessionId());
        response.getWriter().println("getRequestURI() : "+request.getRequestURI());
        response.getWriter().println("getRemoteAddr() : "+request.getRemoteAddr());
        response.getWriter().println("getRemoteHost() : "+request.getRemoteHost());
        response.getWriter().println("getRequestURL() : "+request.getRequestURL());
        response.getWriter().println("getRemotePort() : "+request.getRemotePort());

        response.getWriter().println("getUserPrincipal() : "+request.getUserPrincipal());

        response.getWriter().flush();
    }

}
