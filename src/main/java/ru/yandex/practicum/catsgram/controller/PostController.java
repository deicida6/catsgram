package ru.yandex.practicum.catsgram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public Collection<Post> findAll(
            @RequestParam (required = false) String sort,
            @RequestParam (required = false) Integer size,
            @RequestParam (required = false) Integer from
            ) {
        if (sort != null && (sort.equals("asc") || sort.equals("desc"))
                && from != null && from > 0 && size != null && size > 0) {
            return postService.findAll(sort,size,(from - 1) * size);
        } else {
            return postService.findAll("desc", 10,0); // Возвращаем 10 самых свежих постов по умолчанию
        }
    }

    @GetMapping("/{postId}")
    public Optional<Post> findById(@PathVariable int postId) {
        return postService.findById(postId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping
    public Post update(@RequestBody Post newPost) {
        return postService.update(newPost);
    }
}