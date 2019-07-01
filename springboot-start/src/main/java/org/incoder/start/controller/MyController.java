package org.incoder.start.controller;

import org.incoder.start.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * MyController
 *
 * @author : Jerry xu
 * @date : 2019-06-20  23:40
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson() {
        Person person = new Person();
        person.setId(0);
        person.setName("Blade");
        person.setBirthday(new Date());
        return person;
    }

}
