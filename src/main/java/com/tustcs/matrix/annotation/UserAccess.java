package com.tustcs.matrix.annotation;

import java.lang.annotation.*;

/**
 * Created by polykickshaw on 17-8-28.
 */
@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAccess {
    int level() default 0;

}
