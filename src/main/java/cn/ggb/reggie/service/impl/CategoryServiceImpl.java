package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.Category;
import cn.ggb.reggie.mapper.CategoryMapper;
import cn.ggb.reggie.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
