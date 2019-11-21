package cn.chenlilin.service.impl;


import cn.chenlilin.entity.table.Address;
import cn.chenlilin.mapper.AddressMapper;
import cn.chenlilin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper mapper;

    @Override
    public int insert(Address record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Address selectByPrimaryKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Address> list(Map map) {
        return mapper.list(map);
    }
}
