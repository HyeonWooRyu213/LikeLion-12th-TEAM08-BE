package org.likelion.tm8.user.domain.repository;

import org.likelion.tm8.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
