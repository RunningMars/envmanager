package com.bikego.env.management.service.mapstruct;

import com.bikego.env.management.domain.VariableEntity;
import com.bikego.env.management.service.dto.VariableDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VariableMapper extends BaseMapper<VariableDto, VariableEntity>{

}
