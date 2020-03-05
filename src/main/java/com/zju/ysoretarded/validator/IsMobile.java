package com.zju.ysoretarded.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zcz
 * @CreateTime 2020/3/4 20:17
 */

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IsMobileValidator.class})
public @interface IsMobile {
    boolean required() default true;

    String message() default "手机号码格式有误IsMobileValidator";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
