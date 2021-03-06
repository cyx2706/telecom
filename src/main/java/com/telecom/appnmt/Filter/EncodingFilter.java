package com.telecom.appnmt.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Order(1)
//重点
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter extends OncePerRequestFilter  {
    private String encoding = "UTF-8";

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        //test语句
        //System.out.println("TestFilter1");

        // 设置请求响应字符编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        // 新增加的代码
        HttpServletRequest req = new GetHttpServletRequestWrapper(request, encoding);
        // 传递给目标servlet或jsp的实际上时包装器对象的引用，而不是原始的HttpServletRequest对象
        chain.doFilter(req, response);
    }

    class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private String charset = "UTF-8";

        public GetHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        /**
         * 获得被装饰对象的引用和采用的字符编码
         *
         * @param request
         * @param charset
         */
        public GetHttpServletRequestWrapper(HttpServletRequest request, String charset) {
            super(request);
            this.charset = charset;
        }

        /**
         * 获取单个参数也复写
         */
        public String getParameter(String name) {
            String value = super.getParameter(name);
            try {
                if(value != null){
                    value=new String(value.getBytes("ISO-8859-1"),charset);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }

        /*
         * Spring MVC方法参数自动注入调用的是这个方法
         * {@link RequestParamMethodArgumentResolver}
         */
        public String[] getParameterValues(String name) {
            String[] values = super.getParameterValues(name);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    try {
                        values[i] = new String(values[i].getBytes("ISO-8859-1"),charset);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            return values;
        }
    }
}
