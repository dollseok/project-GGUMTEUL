package dream.challenge.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengePeriod {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengePeriodId;

    private String period;

}


