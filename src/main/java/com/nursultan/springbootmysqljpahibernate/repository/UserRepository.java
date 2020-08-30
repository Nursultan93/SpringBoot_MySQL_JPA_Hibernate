package com.nursultan.springbootmysqljpahibernate.repository;

import com.nursultan.springbootmysqljpahibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
