package com.acvrock.dao;

import com.acvrock.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by moon on 03/11/2016.
 *
 * @Description:
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
