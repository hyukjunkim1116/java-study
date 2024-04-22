package Intermediate1.enum5;

public enum HttpStatus {
    OK(200, "OK"), BAD_REQEUST(400, "Bad Request"), NOT_FOUND(404, "Not Found"), INTERNAL_SERVER_ERROR(500, "Internal Server Error");
    private final int code;
    private final String message;

    HttpStatus(int status, String message) {
        this.message = message;
        this.code = status;
    }

    public static HttpStatus findByCode(int status) {
        for (var http : HttpStatus.values()) {
            if (http.code == status) {
                return http;
            }
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return code < 300 && code >=200;
    }
}
