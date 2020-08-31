package com.SpringBootFreshPrints.SpringBootFreshPrints.users.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootFreshPrints.SpringBootFreshPrints.users.entities.UserInfo;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

}