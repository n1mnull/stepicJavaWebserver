package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MirrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
//        Map<String, Object> pageVariables = createPageVariablesMap(request);
//        String parametersString = pageVariables.get("parameters").toString();
//        if (parametersString.contains("key=[")) {
//            parametersString = parametersString.substring(parametersString.indexOf("key=[")+5);
//            parametersString = parametersString.substring(0,parametersString.indexOf("]"));
//            response.getWriter().println(parametersString);
//        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.containsKey("key")) {
            response.getWriter().println(parameterMap.get("key")[0]);
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }

}
