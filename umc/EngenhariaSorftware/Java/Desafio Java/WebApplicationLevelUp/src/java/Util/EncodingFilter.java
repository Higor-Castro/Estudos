package Util;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author higor
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // Não força sempre text/html, deixa o container definir o correto
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Pode deixar vazio se não precisar configurar nada
    }

    @Override
    public void destroy() {
        // Pode deixar vazio se não precisar liberar recursos
    }
}
