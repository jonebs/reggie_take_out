package cn.ggb.reggie.service.impl;

import cn.ggb.reggie.entity.User;
import cn.ggb.reggie.mapper.UserMapper;
import cn.ggb.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
