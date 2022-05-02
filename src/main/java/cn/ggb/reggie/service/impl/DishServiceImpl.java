package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.common.R;
import cn.ggb.reggie.dto.DishDto;
import cn.ggb.reggie.entity.Dish;
import cn.ggb.reggie.entity.DishFlavor;
import cn.ggb.reggie.mapper.DishMapper;
import cn.ggb.reggie.service.DishFlavorService;
import cn.ggb.reggie.service.DishService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;


    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        baseMapper.insert(dishDto);
        //菜单id
        Long dishId = dishDto.getId();
        //给菜品口味id赋值
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor flavor : flavors) {
            flavor.setDishId(dishId);
        }
        dishFlavorService.saveBatch(flavors);
    }

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    @Override
    public DishDto getByIdWithFlavor(Long id) {

        //查询菜品基本信息，从dish表查询
        Dish dish = baseMapper.selectById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //查询当前菜品对应的口味信息，从dish_flavor表查询
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);

        return dishDto;
    }

    /**
     * 修改菜品
     * @param dishDto
     * @return
     */
    @Override
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
        baseMapper.updateById(dishDto);

        Long dishId = dishDto.getId();

        //清理当前菜品对应口味数据---dish_flavor表的delete操作
        QueryWrapper<DishFlavor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dish_id",dishId);
        dishFlavorService.remove(queryWrapper);

        //重新添加
        //给菜品口味id赋值
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor flavor : flavors) {
            flavor.setDishId(dishId);
        }
        dishFlavorService.saveBatch(flavors);
    }

}
