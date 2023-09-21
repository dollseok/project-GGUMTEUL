package dream.profile.dto.response;

import dream.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseNightProfileHeaderByOther {

    Long userId;
    String nickname;
    String profileImgUrl;
    String profileImgName;
    double wrigglePoint;
    int dreamCardCount;
    int followerCount;
    int followingCount;


    public static ResponseNightProfileHeaderByOther from(User user, int dreamCardCount, int followerCount, int followingCount){
        ResponseNightProfileHeaderByOther response = new ResponseNightProfileHeaderByOther();

        response.userId = user.getUserId();
        response.nickname = user.getNickname();
        response.profileImgName = user.getProfileImageName();
        response.profileImgUrl = user.getProfileUrl();
        response.followerCount = followerCount;
        response.followingCount = followingCount;
        response.wrigglePoint = user.getWrigglePoint();
        response.dreamCardCount = dreamCardCount;


        return response;
    }
}
