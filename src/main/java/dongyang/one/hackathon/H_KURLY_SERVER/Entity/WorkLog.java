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
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(targetEntity = Manager.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    @NotNull
    private String managerId;

    @ManyToOne(targetEntity = Worker.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    @NotNull
    private String workerId;

    @ManyToOne(targetEntity = Work.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    @NotNull
    private String workId;

    @Column(name = "education_completion")
    @CreatedDate
    @NotNull
    private Boolean education_completion;

    // 출근 시간
    @Column(name = "working_time")
    @CreatedDate
    private LocalDateTime working_time;

    // 퇴근 시간
    @Column(name = "leave_work")
    private LocalDateTime leave_work;

    // 근로 배치 여부
    @Column(name = "workRole_add")
    @NotNull
    private Boolean workRoleAdd;

    @Column(name = "working_num")
    @NotNull
    private Integer working_num;
}
