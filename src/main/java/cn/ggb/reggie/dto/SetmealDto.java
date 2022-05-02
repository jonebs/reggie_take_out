package cn.ggb.reggie.dto;

import cn.ggb.reggie.entity.Setmeal;
import cn.ggb.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
