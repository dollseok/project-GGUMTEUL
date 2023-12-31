package dream.common.exception;

public class DuplicateException extends RuntimeException{

    public static final String USER_LIKE_DUPLICATE = "이미 좋아요 한 유저 입니다.";
    public static final String CHALLENGE_DETAIL_LIKE_DUPLICATE = "이미 해당 인증글을 좋아요 했습니다.";
    public static final String CHALLENGE_PARTICIPATION_DUPLICATE = "이미 참여 중인 챌린지 입니다.";
    public static final String NICKNAME_DUPLICATE = "이미 존재하는 닉네임입니다.";
    public static final String FOLLOW_DUPLICATE = "이미 팔로우 중인 회원입니다.";
    public static final String CHLLENGE_DETAIL_DATE_DUPLICATE = "오늘은 이미 인증에 성공한 챌린지입니다.";
    public DuplicateException(String message) {
        super(message);
    }
}
