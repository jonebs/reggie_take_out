package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.DishFlavor;
import cn.ggb.reggie.mapper.DishFlavorMapper;
import cn.ggb.reggie.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
