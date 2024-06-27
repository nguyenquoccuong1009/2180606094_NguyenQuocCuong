package Lab03.QuanLySach.validator;

import Lab03.QuanLySach.entity.User;
import Lab03.QuanLySach.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (user == null) {
            return true; // Valid if user is null
        }
        return user.getId() != null; // Valid if user's id is not null
    }
}
