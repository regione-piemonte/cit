package it.csi.sigit.combustypwabff.model.locsi;

import lombok.Data;

@Data
public class LocsiTokenModel {

    private String access_token;
    private String scope;
    private String token_type;
    private Long expires_in;

}
