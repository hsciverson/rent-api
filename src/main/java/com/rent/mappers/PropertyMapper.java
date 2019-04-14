package com.rent.mappers;

import com.rent.domain.Property;
import org.apache.ibatis.annotations.Param;

public interface PropertyMapper {
    void insert(@Param("property") Property property);

    Property uuid(@Param("uuid") String uuid);
}
