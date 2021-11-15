package com.citybuilder.cityviewer.modules.admin.repository;

import com.citybuilder.cityviewer.modules.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to handle all the user Entity related CRUD operations
 *
 * @author Keshani
 * @since 2021/11/13
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}

