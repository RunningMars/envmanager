package com.bikego.env.management.service;

import com.bikego.env.management.domain.VariableEntity;
import com.bikego.env.management.service.dto.VariableDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface VariableService {

    public List<VariableEntity> list(List<String> nameList,String env,String project);

    public List<VariableEntity> getVariable(String name,String env);

    public Page<VariableEntity> getPageVariable(String name, String env, int pageNo, int pageSize, Sort.Direction dir, String str);

    public Page<VariableEntity> listPage(Pageable pageable, List<String> nameList, String env);

    public boolean add(VariableDto variableDto);

    public boolean addAll(List<VariableDto> variableDtoList);

    public VariableDto info(Integer id);

}
