package com.bikego.env.management.repository;

import com.bikego.env.management.domain.VariableRenderLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VariableRenderLogRepository extends JpaRepository<VariableRenderLogEntity, Long>, JpaSpecificationExecutor<VariableRenderLogEntity> {

//    @Query("SELECT e FROM VariableRenderLogEntity e WHERE e.name like %:name% ")
//    public List<VariableEntity> list(@Param(value = "name") String name);

//    @Query("SELECT e FROM VariableRenderLogEntity e WHERE e.name IN :nameList AND e.env=:env")
//    public List<VariableEntity> list(@Param(value="nameList") List<String> nameList, @Param(value="env") String env);

}
