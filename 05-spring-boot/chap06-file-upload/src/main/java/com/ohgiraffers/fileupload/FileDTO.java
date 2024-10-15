package com.ohgiraffers.fileupload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* 업로드 된 파일과 관련한 정보를 모아서 관리하는 DTO 클래스 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {
    private String originFileName;
    private String savedFileName;
    private String filePath;
    private String fileDescription;
}
