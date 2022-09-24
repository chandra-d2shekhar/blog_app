package com.codewithShekhar.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithShekhar.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
