package scu.edu.cn.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import scu.edu.cn.dao.entity.UserInfo;
import scu.edu.cn.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService service;

    /**
     * 处理登录请求
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o 对象
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String contextPath = httpServletRequest.getContextPath();
        Object username = httpServletRequest.getSession().getAttribute("username");
        Object token = httpServletRequest.getSession().getAttribute("token");
        if (username == null || token == null) {
            httpServletResponse.sendRedirect(contextPath + "/login");
            return false;
        } else {
            UserInfo info = service.selectUserByName((String) username);
            if (info.getToken().equals(token.toString())&&info.getIsAdmin()) {
                return true;
            }
        }

        httpServletResponse.sendRedirect(contextPath + "/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
