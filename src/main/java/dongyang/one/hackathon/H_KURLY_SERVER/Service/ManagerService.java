package dongyang.one.hackathon.H_KURLY_SERVER.Service;

import dongyang.one.hackathon.H_KURLY_SERVER.Dto.ManagerAddDto;
import dongyang.one.hackathon.H_KURLY_SERVER.Entity.Authority;
import dongyang.one.hackathon.H_KURLY_SERVER.Entity.Manager;
import dongyang.one.hackathon.H_KURLY_SERVER.Exception.DuplicateManagerException;
import dongyang.one.hackathon.H_KURLY_SERVER.Repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    public Manager employeeAdd(ManagerAddDto.Request request) {
        if (managerRepository.findOneWithAuthoritiesByBnum(request.getBnum()).orElse(null) != null) {
            throw new DuplicateManagerException("이미 등록된 관리자입니다.");
        }
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        return managerRepository.save(
                Manager.builder()
                        .bnum(request.getBnum())
                        .pw(passwordEncoder.encode(request.getPw()))
                        .name(request.getName())
                        .authorities(Collections.singleton(authority))
                        .build()
        );
    }
}
