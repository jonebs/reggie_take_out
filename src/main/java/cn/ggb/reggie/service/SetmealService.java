package cn.ggb.reggie.service;

import cn.ggb.reggie.dto.SetmealDto;
import cn.ggb.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface SetmealService extends IService<Setmeal> {
    void saveWithFlavor(SetmealDto setmealDto);

    void removeWithDish(List<Long> ids);
}
