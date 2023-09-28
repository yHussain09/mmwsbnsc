package com.unified.ms.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Yasir Hussain");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Yasir", "Hussain" ));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonV1ByRequestParam() {
        return new PersonV1("Yasir Hussain");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonV2ByRequestParam() {
        return new PersonV2(new Name("Yasir", "Hussain" ));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1ByRequestHeader() {
        return new PersonV1("Yasir Hussain");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2ByRequestHeader() {
        return new PersonV2(new Name("Yasir", "Hussain" ));
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1ByAcceptHeader() {
        return new PersonV1("Yasir Hussain");
    }

    @GetMapping(value = "/person/header", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2ByAcceptHeader() {
        return new PersonV2(new Name("Yasir", "Hussain" ));
    }
}
