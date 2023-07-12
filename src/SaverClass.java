import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
public class SaverClass {
    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(container);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
