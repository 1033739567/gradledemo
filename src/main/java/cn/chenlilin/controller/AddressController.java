package cn.chenlilin.controller;


import cn.chenlilin.entity.result.Result;
import cn.chenlilin.entity.result.ResultUtil;
import cn.chenlilin.entity.table.Address;
import cn.chenlilin.entity.query.AddressQuery;
import cn.chenlilin.service.AddressService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    /**
     * 添加收货地址.
     *
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody Address address) {

        // 判断当前用户的收货地址数量是否已达到限制数量
        Map map = new HashMap();
        map.put("userId", address.getUserId());
        map.put("deleted", 0);
        /*List<Address> list = service.list(map);
        if (list != null && list.size() >= 10) {
            throw new ServiceException(ServiceException.CODE_QUANTITATIVE_LIMITATION_ERRO, "新增失败,用户收货地址数量超出限制");
        }*/

        //如果新增的地址为默认地址，先将现有的默认地址改为非默认
        if (address.getIsDefault() != null && address.getIsDefault() == 1) {
            map.put("isDefault", 1);
            List<Address> addressList = service.list(map);
            if (addressList != null && addressList.size() > 0) {
                addressList.forEach((temp) -> {
                    temp.setIsDefault(0);
                    service.updateByPrimaryKeySelective(temp);
                });
            }
        }

        address.setDeleted(0);
        if (address.getIsDefault() == null) {
            address.setIsDefault(0);
        }
        int i = service.insert(address);
        if (i > 0)
            return ResultUtil.success(address);
        else
            return ResultUtil.error("1001","新增地址失败");
    }

    /**
     * 通过id删除收货地址.
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@Param("id") Long id) {
        Address address = service.selectByPrimaryKey(id);
        if (address == null) {
            return ResultUtil.error("404", "该收货地址不存在");
        }
        address.setDeleted(1);

        return ResultUtil.success(service.updateByPrimaryKeySelective(address));
    }

    /**
     * 通过id查询收货地址.
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Result selectById(@Param("id") Long id) {
        return ResultUtil.success(service.selectByPrimaryKey(id));
    }

    /**
     * 编辑收货地址.
     *
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody Address address)  {

        //如果新增的地址为默认地址，先将现有的默认地址改为非默认
        if (address.getIsDefault() != null) {
            Map map = new HashMap();
            map.put("userId", address.getUserId());
            map.put("deleted", 0);
            map.put("isDefault", 1);
            List<Address> addressList = service.list(map);
            if (addressList != null && addressList.size() > 0) {
                for (Address result : addressList) {
                    result.setIsDefault(0);
                    service.updateByPrimaryKeySelective(result);
                }
            }
        }
        Address resultAddress = service.selectByPrimaryKey(address.getId());
        if (resultAddress == null) {
            return ResultUtil.error("404", "该收货地址不存在");
        }

        return ResultUtil.success(service.updateByPrimaryKeySelective(address));
    }

    /**
     * 收货地址列表.
     *
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result list(@RequestBody AddressQuery query) {
        Map map = new HashMap();
        map.put("userId", query.getUserId());
        map.put("deleted", 0);

        return ResultUtil.success(service.list(map));
    }
}
