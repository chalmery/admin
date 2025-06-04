package io.github.user.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO implements Serializable {


    /**
     * 短token
     */
    private String accessToken;

    /**
     * 长token
     */
    private String refreshToken;
}
