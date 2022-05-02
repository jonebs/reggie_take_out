package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.OrderDetail;
import cn.ggb.reggie.mapper.OrderDetailMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService extends ServiceImpl<OrderDetailMapper, OrderDetail> implements cn.ggb.reggie.service.OrderDetailService {
}
