package com.acvrock.dao;


import com.acvrock.domain.Person;
import com.acvrock.support.CustomRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by moon on 30/10/2016.
 *
 * @Description:
 */
public interface PersonRepository extends CustomRepository<Person, Long> {
    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    Person withNameAndAddressNamedQuery(String name, String address);

}
