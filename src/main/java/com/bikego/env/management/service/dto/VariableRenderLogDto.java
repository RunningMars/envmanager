package com.bikego.env.management.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Getter
@Setter
public class VariableRenderLogDto implements Serializable {

    public int id;
    public int variableId;
    public String project;
    public Timestamp createdAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VariableRenderLogDto vDto = (VariableRenderLogDto) o;
        return Objects.equals(id, vDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
