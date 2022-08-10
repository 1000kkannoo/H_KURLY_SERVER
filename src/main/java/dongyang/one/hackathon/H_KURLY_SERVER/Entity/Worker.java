package dongyang.one.hackathon.H_KURLY_SERVER.Entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "user_id", length = 50)
    @NotNull
    private String uid;

    @Column(name = "name", length = 15)
    @NotNull
    private String name;

    @Column(name = "pw")
    @NotNull
    private String pw;

    @Column(name = "gender")
    @NotNull
    private Character gender;

    @Column(name = "phone_num")
    @NotNull
    private String pnum;

    @Column(name = "RRN")
    @NotNull
    private String rrn;

    @Column(name = "slack_off")
    @NotNull
    private Integer slackoff;

    @CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
