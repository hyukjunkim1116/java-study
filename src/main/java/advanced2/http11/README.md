11. http 서버 만들기

**실습 위주로 진행되었음! 강의자료, 코드 확인!**

11-1 http 서버1 - 시작
```java
 public interface HttpServlet {
      void service(HttpRequest request, HttpResponse response) throws
  IOException;
  }
public class HomeServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
        response.writeBody("<h1>home</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href='/site1'>site1</a></li>"); response.writeBody("<li><a href='/site2'>site2</a></li>"); response.writeBody("<li><a href='/search?q=hello'>검색</a></li>"); response.writeBody("</ul>");
    } }
    }
public class Site1Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
        response.writeBody("<h1>site1</h1>");
    }
}
public class Site2Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
        response.writeBody("<h1>site2</h1>");
    }}
public class SearchServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
        String query = request.getParameter("q");
        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    } }
public class NotFoundServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>404 페이지를 찾을 수 없습니다.</h1>"); }
}
}
public class InternalErrorServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setStatusCode(500);
        response.writeBody("<h1>Internal Error</h1>");
    } }
public class DiscardServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
    } }
    }
public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String message) {
        super(message);
    } }
public class ServletManager {
    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet notFoundErrorServlet = new NotFoundServlet();
    private HttpServlet internalErrorServlet = new InternalErrorServlet();
    public ServletManager() {
    }
    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }
    public void setDefaultServlet(HttpServlet defaultServlet) {
        this.defaultServlet = defaultServlet;
    }
    public void setNotFoundErrorServlet(HttpServlet notFoundErrorServlet) {
        this.notFoundErrorServlet = notFoundErrorServlet;
    }
    public void setInternalErrorServlet(HttpServlet internalErrorServlet) {
        this.internalErrorServlet = internalErrorServlet;
    }
    public void execute(HttpRequest request, HttpResponse response) throws
            IOException {
        try {
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(),
                    defaultServlet);
            if (servlet == null) {
                throw new PageNotFoundException("request url= " +
                        request.getPath());
            }
            servlet.service(request, response);
        } catch (PageNotFoundException e) {
            e.printStackTrace();
            notFoundErrorServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            internalErrorServlet.service(request, response);
        } }
}
public class HttpRequestHandler implements Runnable {
    private final Socket socket;
    private final ServletManager servletManager;
    public HttpRequestHandler(Socket socket, ServletManager servletManager) {
        this.socket = socket;
        this.servletManager = servletManager;
    }
    @Override
    public void run() {
        try {
            process(socket);
        } catch (Exception e) {
            log(e);
            e.printStackTrace();
        }
    }
    private void process(Socket socket) throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new
                     InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(),
                     false, UTF_8)) {
            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);
            log("HTTP 요청: " + request); servletManager.execute(request, response); response.flush();
            log("HTTP 응답 완료");
        } }
}
public class HttpServer {
    private final ExecutorService es = Executors.newFixedThreadPool(10);
    private final int port;
    private final ServletManager servletManager;
    public HttpServer(int port, ServletManager servletManager) {
        this.port = port;
        this.servletManager = servletManager;
    }
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port); log("서버 시작 port: " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            es.submit(new HttpRequestHandler(socket, servletManager));
        } }
}
    }
public class ServerMainV5 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.add("/", new HomeServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2", new Site2Servlet());
        servletManager.add("/search", new SearchServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());
        HttpServer server = new HttpServer(PORT, servletManager);
        server.start();
    }
}

```