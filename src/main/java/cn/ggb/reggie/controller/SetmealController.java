package cn.ggb.reggie.controller;

import cn.ggb.reggie.common.R;
import cn.ggb.reggie.dto.SetmealDto;
import cn.ggb.reggie.entity.Category;
import cn.ggb.reggie.entity.Dish;
import cn.ggb.reggie.entity.Setmeal;
import cn.ggb.reggie.service.CategoryService;
import cn.ggb.reggie.service.SetmealDishService;
import cn.ggb.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){

        setmealService.saveWithFlavor(setmealDto);
        return R.success("新增套餐成功");
    }

    /**
     *套餐分页查询
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){

        //分页构造器对象
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null,Setmeal::getName,name);
        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = new ArrayList<>();

        for (Setmeal record : records) {
            SetmealDto setmealDto = new SetmealDto();

            BeanUtils.copyProperties(record,setmealDto);

            Long categoryId = record.getCategoryId();
            //根据categoryId查询categoryName
            Category category = categoryService.getById(categoryId);

            if (categoryId != null){
                String categoryName = category.getName();

                setmealDto.setCategoryName(categoryName);
            }
            list.add(setmealDto);
        }
        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }

    /**
     * 删除套餐
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(@RequestParam List<Long> ids){

        setmealService.removeWithDish(ids);

        return R.success("套餐数据删除成功！");
    }

    /**
     * 根据条件查询套餐数据
     * @param setmeal
     * @return
     */
    @GetMapping("/list")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal>  wrapper = new LambdaQueryWrapper<Setmeal>();
        wrapper.eq(setmeal.getCategoryId() != null ,Setmeal::getCategoryId,setmeal.getCategoryId());
        wrapper.eq(setmeal.getStatus() != null,Setmeal::getStatus,setmeal.getStatus());
        wrapper.orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> list = setmealService.list(wrapper);
        return R.success(list);
    }
}
