package com.etiqaassessment.repository;

import com.etiqaassessment.domain.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FamilyMembersRepository extends JpaRepository<FamilyMember, Long> {
    @Query("SELECT f FROM FamilyMember f WHERE f.customer.customer_id = :customerId")
    List<FamilyMember> findByCustomerId(@Param("customerId") Integer customerId);
}
