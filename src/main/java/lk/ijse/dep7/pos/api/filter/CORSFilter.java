<<<<<<< HEAD:src/main/java/lk/ijse/dep7/pos/api/api/filter/CORSFilter.java
package lk.ijse.dep7.pos.pos.api.filter;
=======
package lk.ijse.dep7.pos.api.filter;
>>>>>>> 185a64c963233ba22a727108aa356b4295409eda:src/main/java/lk/ijse/dep7/pos/api/filter/CORSFilter.java

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
public class CORSFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");

        if (req.getMethod().equalsIgnoreCase("OPTIONS")){
            resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
            resp.setHeader("Access-Control-Allow-Methods", "POST, PUT, DELETE, GET");
        }

        if (req.getMethod().equalsIgnoreCase("GET")){
            resp.setHeader("Access-Control-Expose-Headers", "X-Total-Count");
        }

        filterChain.doFilter(req, resp);
    }

}
