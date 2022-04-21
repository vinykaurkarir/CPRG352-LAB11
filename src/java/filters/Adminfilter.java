
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

public class Adminfilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        
        int userRole = (int)session.getAttribute("role");
        
        if(userRole != 1){
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            httpResponse.sendRedirect("notes");
            return;
        }
        
        chain.doFilter(request, response);
        
    }
    
     @Override
    public void destroy() {}
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
}   
