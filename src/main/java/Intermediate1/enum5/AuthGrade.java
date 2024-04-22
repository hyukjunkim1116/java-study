package Intermediate1.enum5;

public enum AuthGrade {
    GUEST(1, "손님"),LOGIN(2,"로그인 회원"),ADMIN(3,"관리자");
    private final int level;
    private final String description;

    AuthGrade(int level, String description) {
        this.description = description;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
}
