package it.csi.sigit.combustypwabff.model.sigitext;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SigitextErrore {

    private String status;
    private String code;
    private String title;
    private List<String> links;

}
