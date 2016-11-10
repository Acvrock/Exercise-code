package com.acvrock.service;

import com.acvrock.dao.PersonRepository;
import com.acvrock.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by moon on 04/11/2016.
 *
 * @Description:
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("xx")) {
            throw new IllegalArgumentException("xx 已经存在，数据回滚");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {


        Person save = personRepository.save(person);
        if (person.getName().equals("xx")) {
            throw new IllegalArgumentException("xx 已经存在，数据将不会回滚");
        }
        return save;
    }
}
