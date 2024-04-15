import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class ConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String minCelsiusStr = request.getParameter("minCelsius");
        String maxCelsiusStr = request.getParameter("maxCelsius");
        String incrementStr = request.getParameter("increment");

        if (minCelsiusStr == null || maxCelsiusStr == null || incrementStr == null) {
            response.getWriter().println("Por favor, preencha todos os campos.");
            return;
        }

        double minCelsius = Double.parseDouble(minCelsiusStr);
        double maxCelsius = Double.parseDouble(maxCelsiusStr);
        double increment = Double.parseDouble(incrementStr);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<table border='1'><tr><th>Celsius (°C)</th><th>Fahrenheit (°F)</th><th>Kelvin (°K)</th></tr>");

        double celsius = minCelsius;
        while (celsius <= maxCelsius) {
            double fahrenheit = celsius * 9/5 + 32;
            double kelvin = celsius + 273.15;
            response.getWriter().println("<tr><td>" + celsius + "</td><td>" + fahrenheit + "</td><td>" + kelvin + "</td></tr>");
            celsius += increment;
        }

        response.getWriter().println("</table></body></html>");
    }
}
