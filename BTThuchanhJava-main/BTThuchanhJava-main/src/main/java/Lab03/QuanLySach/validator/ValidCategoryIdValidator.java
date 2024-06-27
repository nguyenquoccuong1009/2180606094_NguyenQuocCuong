package Lab03.QuanLySach.validator;

import Lab03.QuanLySach.entity.Category;
import Lab03.QuanLySach.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {

    @Override
    public void initialize(ValidCategoryId constraintAnnotation) {
        // Initialization logic, if needed
    }

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        if (category == null) {
            return false; // Trả về false nếu category là null
        }

        Long categoryId = category.getId();
        if (categoryId == null || categoryId <= 0) {
            return false; // Trả về false nếu categoryId không hợp lệ
        }

        return true; // Nếu categoryId hợp lệ, trả về true
    }
}
