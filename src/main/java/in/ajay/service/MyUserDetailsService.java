package in.ajay.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("LoadUserByUsername method called....");
		
		// Logic to get user data
		// userRepo.findByUsername(name);    --------> in case of DataJpa usage
		
		return new User("ajay","ajay@123", Collections.emptyList());
		
	}

}
