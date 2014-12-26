package demo;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new PolicyValidator());
	}
	
	@RequestMapping(value = "/policies", method = RequestMethod.POST)
	public ResponseEntity<PolicyResource> savePolicies(
			@Valid @RequestBody PolicyResource policyResource) {

		// System.out.println(bindingResult.getErrorCount());

		System.out.println(policyResource.getName());

		return new ResponseEntity<PolicyResource>(policyResource, HttpStatus.OK);
	}
	
}
