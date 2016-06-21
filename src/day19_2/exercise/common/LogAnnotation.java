package day19_2.exercise.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
@Inherited
@Retention(value=RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

}
