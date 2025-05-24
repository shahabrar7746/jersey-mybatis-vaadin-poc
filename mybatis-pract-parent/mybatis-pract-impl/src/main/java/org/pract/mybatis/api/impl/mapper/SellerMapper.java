package org.pract.mybatis.api.impl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.pract.mybatis.api.dto.SellerDto;
import org.pract.mybatis.api.impl.models.SellerModel;

import java.util.List;

@Mapper
public interface SellerMapper {
    List<String> findAllSellerNameById(List<Integer> ids);

    String findSellerNameById(Integer id);

    SellerModel findByName(String name);


    SellerDto toDto(Integer id);

    List<String> findAllSellerName();

}
