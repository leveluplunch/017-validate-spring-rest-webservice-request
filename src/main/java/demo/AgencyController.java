package demo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgencyController {

	@RequestMapping(value = "/agencies", method = RequestMethod.GET)
	public List<AgencyResource> getAgencies() {
		List<AgencyResource> agencies = getListing();
		return agencies;
	}
	
	@RequestMapping(value = "/agencies", method = RequestMethod.POST)
	public ResponseEntity<AgencyResource> saveAgency(
			@Valid @RequestBody AgencyResource agencyResource) {

		System.out.println(agencyResource.getName());
		
		//save to db or ? 

		return new ResponseEntity<AgencyResource>(agencyResource, HttpStatus.OK);
	}
	

	private List<AgencyResource> getListing() {

		List<AgencyResource> resources = new ArrayList<>();
		resources.add(new AgencyResource(1, "all state", "123"));
		resources.add(new AgencyResource(2, "fcci insurance group", "456"));
		resources.add(new AgencyResource(3, "farmers", "789"));
		resources.add(new AgencyResource(4, "met life", "167"));

		return resources;
	}

}
