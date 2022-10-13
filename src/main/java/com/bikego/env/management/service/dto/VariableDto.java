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
public class VariableDto implements Serializable {
    public int id;
    public  String name;
    public String value;
    public String env;
    public String createdBy;
    public String updatedBy;
    public int renderNum;
    public Timestamp createdAt;
    public Timestamp updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VariableDto vDto = (VariableDto) o;
        return Objects.equals(id, vDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
