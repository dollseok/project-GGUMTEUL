package dream.user.domain;

import dream.common.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String nickname;
    private int point;
    private String profileImageName;
    private String profileUrl;
    private Double wrigglePoint;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void authorizeUser() {
        this.role = Role.USER;
    }
    public void updateNickname(String updateNickname) {
        this.nickname = updateNickname;
    }
    @Builder
    public User(Long userId, String name, String nickname, int point, String profileImageName, String profileUrl, Double wrigglePoint, String email, Role role){

        this.userId = userId;
        this.name = name;
        this.nickname = nickname;
        this.point = point;
        this.profileImageName = profileImageName;
        this.profileUrl = profileUrl;
        this.wrigglePoint = wrigglePoint;
        this.email = email;
        this.role = role;
    }

    public void minusPoint(int point){
        this.point -= point;
    }
    public void plusPoint(int point){
        this.point += point;
    }

    public void updateProfileUrl(String updateProfileUrlName){
        this.profileUrl = updateProfileUrlName;
    }


    public void updatePoint(int point){
        this.point += point;
    }

    public void updateWrigglePoint(double wrigglePoint){
        this.wrigglePoint += wrigglePoint;
    }


}
