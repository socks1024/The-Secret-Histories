package TheSecretHistories.Utils;

public class DebugUtils {
    public static <E> void LogNull(E var, String name) {
        if (var == null) Log(name + " is Null");
        else Log(name + " is not Null");
    }

    public static <E> void Log(E var) {
        System.out.println(StringUtils.MakeDebug(var.toString()));
    }
}
