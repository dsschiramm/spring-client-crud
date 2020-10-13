package restapi.springclientcrud.validator;

import restapi.springclientcrud.constraint.SexConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<SexConstraint, String> {

    @Override
    public void initialize(SexConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String sex, ConstraintValidatorContext constraintContext) {

        if (sex == null) {
            return true;
        } else if (sex.equals("")) {
            return false;
        } else if (sex.equals("FEMENINO") || sex.equals("MASCULINO")) {
            return true;
        } else {
            return false;
        }
    }
}