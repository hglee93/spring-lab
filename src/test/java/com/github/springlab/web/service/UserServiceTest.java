package com.github.springlab.web.service;

import com.github.springlab.web.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired MongoTemplate mongoTemplate;

    @Test
    public void find_one() {

        // given
        Random random = new Random();

        User saveUser = new User();
        saveUser.setName(String.format("Lee%d", random.nextInt()));
        saveUser.setAge(random.nextInt());

        User user = mongoTemplate.save(saveUser);

        // when
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(user.getName()));
        User findUser = mongoTemplate.findOne(query, User.class);

        // then
        assertThat(findUser.getId()).isNotBlank();
        assertThat(findUser.getName()).isEqualTo(saveUser.getName());
        assertThat(findUser.getAge()).isEqualTo(saveUser.getAge());

        System.out.println(findUser.getId());

    }

}