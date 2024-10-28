package sem;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class returnjson {
static class User { String name = "John Doe"; int age = 30; }
public static void main(String[] args) throws Exception {
HttpServer.create(new InetSocketAddress(8080), 0).createContext("/user", exchange -> {
String response = String.format("{\"name\":\"%s\",\"age\":%d}", new User().name, new User().age);
exchange.getResponseHeaders().set("Content-Type", "application/json");
exchange.sendResponseHeaders(200, response.length());
OutputStream os = exchange.getResponseBody(); os.write(response.getBytes()); os.close();
}).start();
}
}
