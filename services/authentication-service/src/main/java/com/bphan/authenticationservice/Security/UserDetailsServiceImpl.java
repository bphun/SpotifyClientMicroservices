package com.bphan.authenticationservice.Security;

import java.util.List;

import com.bphan.authenticationservice.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<AppUser> appUsers = userRepository.findUserWithName(username);

		if (appUsers.size() >= 1 && appUsers.get(0) != null) {
			appUsers.get(0).setPassword(passwordEncoder.encode(appUsers.get(0).getPassword()));

			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + appUsers.get(0).getRole());

			return new User(appUsers.get(0).getUsername(), appUsers.get(0).getPassword(), grantedAuthorities);
		}

		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
}