package webrix.hr.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webrix.hr.entity.userModel;
import webrix.hr.repo.userRepo;

@Service
public class userServiceImpl implements UserDetailsService {
	@Autowired
	userRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userModel user = repo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetailsiImpl.build(user);
	}

}
