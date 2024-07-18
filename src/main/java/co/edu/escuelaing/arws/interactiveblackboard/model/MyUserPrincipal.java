package co.edu.escuelaing.arws.interactiveblackboard.model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.escuelaing.arws.interactiveblackboard.entity.User;

public class MyUserPrincipal implements UserDetails {
    private User user;
	private final Set<GrantedAuthority> authorities;
    
	@SuppressWarnings("unchecked")
    public MyUserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
		this.user= user;
        this.authorities= (Set<GrantedAuthority>) authorities;
	}

    @Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return user.getPass();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}


}
