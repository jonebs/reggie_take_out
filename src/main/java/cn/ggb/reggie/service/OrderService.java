package cn.ggb.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.ggb.reggie.entity.Orders;

public interface OrderService extends IService<Orders> {

    void submit(Orders orders);
}
