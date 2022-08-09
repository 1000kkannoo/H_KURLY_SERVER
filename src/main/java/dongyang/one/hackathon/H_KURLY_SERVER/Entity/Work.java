package dongyang.one.hackathon.H_KURLY_SERVER.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(targetEntity = WorkPlace.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkPlace")
    @NotNull
    private String wPlace;

    @ManyToOne(targetEntity = WorkRole.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkRole")
    @NotNull
    private String workRole;

    @ManyToOne(targetEntity = WorkTime.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "WorkTime")
    @NotNull
    private String workTime;

    @Column(name = "WorkDay")
    @CreatedDate
    private LocalDateTime workDay;

    @Column(name = "wage")
    @NotNull
    private Integer wage;
}
