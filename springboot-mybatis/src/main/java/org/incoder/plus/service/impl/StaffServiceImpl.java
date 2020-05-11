package org.incoder.plus.service.impl;

import org.incoder.plus.entity.Staff;
import org.incoder.plus.mapper.StaffMapper;
import org.incoder.plus.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author Jerry xu
 * @since 2020-05-10
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

}
