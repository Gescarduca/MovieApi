package guilherme.escarduca.MovieApi.CustomValidators;

import guilherme.escarduca.MovieApi.CustomAnnotations.MovieRevenue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MovieRevenueValidator implements ConstraintValidator <MovieRevenue, Double> {

    private double defaultRevenue;

    @Override
    public void initialize(MovieRevenue constraintAnnotation) {
        defaultRevenue = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Double revenueValue, ConstraintValidatorContext constraintValidatorContext) {
        //Note: we can add any custom logic inside this method including but not limited to calling a webservice do some number logic etc...
        System.out.println("This is the revenue value: " + revenueValue);
        return revenueValue>=this.defaultRevenue;
    }
}
