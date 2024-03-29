package com.quizz.rest.Controller;

import com.quizz.rest.Model.Tag;
import com.quizz.rest.Repository.TagRepository;
import com.quizz.rest.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @PostMapping("/savetag")
    public String saveTag(Tag tag) {
        tagService.saveTag(tag);
        return "Tag saved";
    }

    @PutMapping("/updatetag/{id}")
    public String updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        tagService.updateTag(id, tag);
        return "Tag updated";
    }

    @DeleteMapping("/deletetag/{id}")
    public String deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "Tag deleted";
    }
}
