package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.ShoppingCart;
import cn.ggb.reggie.mapper.ShoppingCartMapper;
import cn.ggb.reggie.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
