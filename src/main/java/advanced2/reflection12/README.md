12. 리플렉션

12-1 클래스와 메타데이터
```html
클래스가 제공하는 다양한 정보를 동적으로 분석하고 사용하는 기능을 리플렉션이라고 한다.
클래스의 메타데이터, 필드 정보, 메서드 정보, 생성자 정보를 알 수있다.
```

12-2 리플렉션을 추가한 서블릿
```java
public class ReflectionServlet implements HttpServlet {
    private final List<Object> controllers;

    public ReflectionServlet(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws
            IOException {
        String path = request.getPath();
        for (Object controller : controllers) {
            Class<?> aClass = controller.getClass();
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (path.equals("/" + methodName)) {
                    invoke(controller, method, request, response);
                    return;
                }
            }
        }
        throw new PageNotFoundException("request=" + path);
    }

    private static void invoke(Object controller, Method method, HttpRequest
            request, HttpResponse response) {
        try {
            method.invoke(controller, request, response);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
```