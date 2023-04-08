package guilherme.escarduca.MovieApi.CustomAnnotations;

import guilherme.escarduca.MovieApi.CustomValidators.MovieRevenueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MovieRevenueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})//This specifies the place you can use this annotation
@Retention(RetentionPolicy.RUNTIME)//to be used in runtime
public @interface MovieRevenue {
    //define default revenue value
    public double value() default 0000.00;
    //define default error message
    public String message() default "must be above 0";
    //define default groups
    public Class<?> [] groups() default {};
    //define default payloads
    public Class<? extends Payload>[] payload() default {};
}
