package lk.ijse.bikereservation.repository;

import lk.ijse.bikereservation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Chalodya
 * @since 2019/09
 **/
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(value = "SELECT * FROM auth_role u WHERE u. role_desc = :rolee",
            nativeQuery = true)
    Role findRoleByRole(
            @Param("rolee") String rolee);


    @Modifying
    @Query(value = "insert into auth_user_role values (:guestId, :role_id )",
            nativeQuery = true)
    @Transactional
    void insertauth_user_role(@Param("guestId") Integer userId, @Param("role_id") Integer rolId);
}
