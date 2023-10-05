package day2;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pojo_PostRequest {
    private String name;
    private String location;
    private String phone;
    private String courses[];

}
