package cn.chenlilin.service;


import cn.chenlilin.entity.table.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {

    int insert(Address record);

    Address selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Address record);

    List<Address> list(Map map);
}
