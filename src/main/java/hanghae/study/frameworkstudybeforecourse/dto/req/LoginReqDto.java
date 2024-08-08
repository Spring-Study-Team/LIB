package hanghae.study.frameworkstudybeforecourse.dto.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginReqDto {

    private String userName;
    private String pw;
}
