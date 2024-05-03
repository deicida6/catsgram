package ru.yandex.practicum.catsgram.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Image {
    private Long id;
    private Long postId;
    private String originalFileName;
    private String filePath;
}
