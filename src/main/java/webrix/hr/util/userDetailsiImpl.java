package webrix.hr.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import webrix.hr.entity.userModel;

public class userDetailsiImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public userDetailsiImpl(int id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
		this.email = username;
		this.password = password;
		this.id = id;
	}

	public static UserDetails build(userModel user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
		return new userDetailsiImpl(user.getId(), user.getEmail(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub

		return authorities;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
