package com.mes.jss.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mes.jss.user.UserVO;
import com.mes.jss.user.mapper.UserMapper;
import com.mes.jss.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired UserMapper userMapper;
	
	@Override
	public UserVO gerUser(UserVO vo) {

		return userMapper.getUser(vo);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 단건조회
		UserVO userVO = new UserVO();
		userVO.setLoginId(username);
		UserVO vo =  userMapper.getUser(userVO);		

		// id 없으면 에러
		if(vo == null) {
			throw new UsernameNotFoundException("no id");
		}

		// id 있으면 vo return
		return vo;		// Principal
	}

}
