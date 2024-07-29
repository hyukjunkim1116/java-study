package advanced1.executer12;

import java.util.concurrent.Callable;

public interface Work extends Callable<Boolean> {

    Boolean call();
}
