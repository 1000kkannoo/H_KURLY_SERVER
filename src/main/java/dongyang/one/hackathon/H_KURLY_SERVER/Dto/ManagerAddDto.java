package dongyang.one.hackathon.H_KURLY_SERVER.Dto;

import lombok.*;

import javax.validation.constraints.NotNull;


public class ManagerAddDto {

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

        @NotNull
        private String name;

    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private String bnum;
        private String pw;
        private String name;

    }
}
