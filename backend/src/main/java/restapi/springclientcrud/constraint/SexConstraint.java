package restapi.springclientcrud.constraint;

import restapi.springclientcrud.validator.SexValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SexValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE  })
@Retention(RetentionPolicy.RUNTIME)
public @interface SexConstraint {

    String message() default "O sexo deve ser Masculino ou Femenino";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}