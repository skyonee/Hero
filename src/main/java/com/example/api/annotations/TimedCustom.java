package com.example.api.annotations;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TimedCustom {
}
