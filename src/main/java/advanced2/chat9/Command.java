package advanced2.chat9;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
