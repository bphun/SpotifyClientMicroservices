package com.bphan.authenticationservice.Security;

import java.util.Arrays;
import java.util.List;

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
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// hard coding the users. All passwords must be encoded.
		final List<AppUser> users = Arrays.asList(
			new AppUser(1, "bphun", passwordEncoder.encode("12345"), "USER"),
			new AppUser(2, "admin", passwordEncoder.encode("123"), "ADMIN")
		);

		for (AppUser appUser : users) {
			if (appUser.getUsername().equals(username)) {

				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole());

				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
			}
		}

		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

	private static class AppUser {
		private Integer id;
		private String username, password;
		private String role;

		public AppUser(Integer id, String username, String password, String role) {
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}

		public String getRole() {
			return role;
		}
	}

}