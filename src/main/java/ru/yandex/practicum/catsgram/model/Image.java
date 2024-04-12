package ru.yandex.practicum.catsgram.model;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Image {
    Long id;
    Long postId;
    String originalFileName;
    String filePath;
}
