package com.example.demo.repo;

import com.example.demo.entity.DoraSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface rpo extends JpaRepository<DoraSample,Long> {

//   @Query (value = "select * from attachments where id=:sId",nativeQuery = true)
//    DoraSample findFirstById(@Param("sId") Long sId);
}
