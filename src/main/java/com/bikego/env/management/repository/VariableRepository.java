package com.bikego.env.management.repository;

import com.bikego.env.management.domain.VariableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VariableRepository extends JpaRepository<VariableEntity, Long>, JpaSpecificationExecutor<VariableEntity> {

//    @Query("SELECT e FROM VariableEntity e WHERE e.name like %:name% ")
//    public List<VariableEntity> list(@Param(value = "name") String name);

    @Query("SELECT e FROM VariableEntity e WHERE e.name IN :nameList AND e.env=:env")
    public List<VariableEntity> list(@Param(value="nameList") List<String> nameList, @Param(value="env") String env);

    @Query("SELECT e FROM VariableEntity e WHERE e.id = :id  ")
    public VariableEntity info(@Param(value="id") Integer id);

    @Query("SELECT e FROM VariableEntity e WHERE e.name IN :nameList AND e.env=:env")
    public Page<VariableEntity> listPage(@Param(value="nameList") List<String> nameList, @Param(value="env") String env,Pageable pageable);

    @Query("SELECT e FROM VariableEntity e WHERE e.name = :name AND e.env=:env")
    public List<VariableEntity> getVariable(@Param(value="name") String name, @Param(value="env") String env);

//    @Query("SELECT v.*,r.project,r.created_at FROM variable AS v LEFT JOIN ( SELECT vrl.variable_id,vrl.project,vrl.created_at \tFROM variable_render_log AS vrl LEFT JOIN (  SELECT MAX(id) AS id, variable_id FROM variable_render_log GROUP BY variable_id ) AS b ON vrl.variable_id = b.variable_id WHERE vrl.id = b.id ) AS r ON r.variable_id = v.id")
//    public List<VariableEntity> getVariable(@Param(value="name") String name, @Param(value="env") String env);

}
