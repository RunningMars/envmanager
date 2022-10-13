package com.bikego.env.management.service.mapstruct;

import com.bikego.env.management.domain.VariableRenderLogEntity;
import com.bikego.env.management.service.dto.VariableRenderLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VariableRenderLogMapper extends BaseMapper<VariableRenderLogDto, VariableRenderLogEntity>{

}
