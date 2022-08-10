package dongyang.one.hackathon.H_KURLY_SERVER.Dto;

import lombok.*;

import javax.validation.constraints.NotNull;


public class ManagerLoginDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request{
        @NotNull
        private String bnum;
        @NotNull
        private String pw;
    }
}
