/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Viny karir
 */
public class AuthFilter implements Filter {

   

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)response;
        HttpSession session= httpRequest.getSession();
        String email = (String) session.getAttribute("email");
        
        if(email==null)
        {
            HttpServletResponse httpResponse = (HttpServletResponse)request;
            httpResponse.sendRedirect("login");
            return;
        }
        
        //Any code before chain.doFilter() will be executed before the servlet
        chain.doFilter(request, response);
        //Any code after chain.doFilter() will be executed after the servlet
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }
    
    @Override
    public void destroy() {
    
    }
    
}
