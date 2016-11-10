package com.acvrock.service;

import com.acvrock.domain.Person;

/**
 * Created by moon on 04/11/2016.
 *
 * @Description:
 */
public interface DemoService {
    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);
}
