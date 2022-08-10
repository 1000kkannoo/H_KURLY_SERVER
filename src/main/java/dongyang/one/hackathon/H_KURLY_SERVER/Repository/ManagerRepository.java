package dongyang.one.hackathon.H_KURLY_SERVER.Repository;

import dongyang.one.hackathon.H_KURLY_SERVER.Entity.Manager;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager,Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<Manager> findOneWithAuthoritiesByBnum(String bnum);
}
