package com.team11.shareoffice.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDto {
    private Long roomId; // 방번호
    private String sender; // nickname
    private String content; // 메시지
}