package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.Employee;
import cn.ggb.reggie.mapper.EmployeeMapper;
import cn.ggb.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
