package org.pmckit.helpers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation allows us to Generate a compilation Warning indicating that
 * the usage of that method is not recommended
 * 
 * @author fabienkruba
 * 
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD,
		ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE })
public @interface BeCareful {
	public abstract java.lang.String[] value();
}
