package cn.ggb.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ggb.reggie.entity.AddressBook;
import cn.ggb.reggie.mapper.AddressBookMapper;
import cn.ggb.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
