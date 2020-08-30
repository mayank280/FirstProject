package com.example.applications.repositary;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.applications.model.User_Nested;


public interface UsersRepo extends JpaRepository<User_Nested,String> {
	@Query(value = "UPDATE angulardset.user_nested set username = :u, password =:p, email =:e, phonenum =:i where id = :id",nativeQuery = true)
	@Modifying
	@Transactional
	void findUpdateById(String id,String u,String p, String e, String[] i);
	
	@Query(value = "select * from angulardset.user_nested where email =:e and password =:p", nativeQuery = true)
	List<User_Nested> findByLogInCred(String e,String p);
	

}
