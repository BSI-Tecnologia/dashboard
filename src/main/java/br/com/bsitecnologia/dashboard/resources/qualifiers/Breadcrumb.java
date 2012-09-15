package br.com.bsitecnologia.dashboard.resources.qualifiers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Named;
import javax.inject.Qualifier;

@Qualifier
@Named
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Breadcrumb {

}
