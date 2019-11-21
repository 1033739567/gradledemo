package cn.chenlilin.mapper;


import cn.chenlilin.entity.table.Address;

import java.util.List;
import java.util.Map;

public interface AddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> list(Map map);
}