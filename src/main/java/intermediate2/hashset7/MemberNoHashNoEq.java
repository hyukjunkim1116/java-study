package intermediate2.hashset7;

import java.util.Objects;

public class MemberNoHashNoEq {
    private String id;
    public MemberNoHashNoEq(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberNoHashNoEq that = (MemberNoHashNoEq) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberNoHashNoEq{" +
                "id='" + id + '\'' + '}';
    }
}
