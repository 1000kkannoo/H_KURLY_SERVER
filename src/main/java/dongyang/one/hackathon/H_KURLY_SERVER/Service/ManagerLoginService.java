package dongyang.one.hackathon.H_KURLY_SERVER.Service;

import dongyang.one.hackathon.H_KURLY_SERVER.Entity.Manager;
import dongyang.one.hackathon.H_KURLY_SERVER.Repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component("userDetailsService")
@RequiredArgsConstructor
public class ManagerLoginService implements UserDetailsService {
    private final ManagerRepository managerRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        return managerRepository.findOneWithAuthoritiesByBnum(email)
                .map(user -> createUser(user))
                .orElseThrow(() -> new UsernameNotFoundException(email + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    private User createUser(Manager manager) {

        List<GrantedAuthority> grantedAuthorities = manager.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new User(manager.getBnum(),
                manager.getPw(),
                grantedAuthorities
        );
    }
}
