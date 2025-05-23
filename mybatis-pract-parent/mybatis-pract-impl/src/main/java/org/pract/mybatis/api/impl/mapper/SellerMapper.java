package org.pract.mybatis.api.impl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.pract.mybatis.api.dto.SellerDto;

import java.util.List;

@Mapper
public interface SellerMapper {
List<String> findAllSellerName(List<Integer> ids);
String findSellerNameById(Integer id);

//@InheritInverseConfiguration
SellerDto toDto(Integer id);

}
