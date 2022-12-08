package ms.gradems.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenMsg {

    private Integer id;
    private String role;
    private String num;

}
