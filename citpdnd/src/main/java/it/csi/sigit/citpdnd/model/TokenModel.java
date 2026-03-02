package it.csi.sigit.citpdnd.model;

import lombok.Data;

@Data
public class TokenModel {

    private String access_token;
    private String scope;
    private String token_type;
    private Long expires_in;

}
