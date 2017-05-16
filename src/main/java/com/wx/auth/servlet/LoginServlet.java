package com.wx.auth.servlet;

import com.wx.auth.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by saras on 2017/5/15.
 */

@WebServlet("/wxLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
//        外网可以访问的地址
//        String backUrl = "/WxAuth/callBack";
        String backUrl = "/WxAuth/wxCallBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ AuthUtil.APPID
                +"&redirect_uri="+ URLEncoder.encode(backUrl)
                +"&response_type=code"
                +"&scope=snsapi_userinfo"
                +"&state=STATE#wechat_redirect";
        resp.sendRedirect(url);
    }
}
