import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.*;


@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo{
String path();
}

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
 @interface Saver{}

@SaveTo(path ="C:\\Users\\Виктория\\Desktop\\file.txt")
public class TextContainer {
    String text = "text";
    @Saver
    public void save() {
        try {
            Class<?> cls = this.getClass();
            if (cls.isAnnotationPresent(SaveTo.class)) {
                SaveTo annotation = cls.getAnnotation(SaveTo.class);
                String path = annotation.path();
                FileWriter writer = new FileWriter(path);
                writer.write(text);
                writer.close();
                System.out.println("Text saved to file: " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
