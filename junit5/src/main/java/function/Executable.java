package function;

import org.apiguardian.api.API;
import org.apiguardian.api.API.Status;

@FunctionalInterface
@API(
    status = Status.STABLE,
    since = "5.0"
)
public interface Executable {
    void execute() throws Throwable;
}
