package com.nextgenretro.nextgenretro.model.repository;

import com.nextgenretro.nextgenretro.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
