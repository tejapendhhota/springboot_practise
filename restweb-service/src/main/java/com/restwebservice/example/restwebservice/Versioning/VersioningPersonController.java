package com.restwebservice.example.restwebservice.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charile");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 geSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "person", params = "version-2")
	public PersonV2 getFirstVersionOfPersonRequestParamter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "person", headers = "X-API-VERSION=2")
	public PersonV2 getFirstVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "person", headers = "json-v2")
	public PersonV2 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
