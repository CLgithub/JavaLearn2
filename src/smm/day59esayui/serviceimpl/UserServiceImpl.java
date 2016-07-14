package smm.day59esayui.serviceimpl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import smm.common.entity.User;
import smm.common.mapperbase.BaseMapper;
import smm.common.servicebase.BaseServiceImpl;
import smm.day59esayui.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userMapper")
	public void setBaseMapper(BaseMapper<User> baseMapper) {
		super.setBaseMapper(baseMapper);
	}
	
	
}
