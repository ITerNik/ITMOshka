package annotations;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Builder {
    String field() default "";
    String[] variants() default {};
    int order();
}

