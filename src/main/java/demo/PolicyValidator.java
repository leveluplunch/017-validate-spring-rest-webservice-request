

package demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PolicyValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return PolicyResource.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");

		PolicyResource p = (PolicyResource) target;
		
		//perform additional checks
		//if name already exists or ?
	}
}
