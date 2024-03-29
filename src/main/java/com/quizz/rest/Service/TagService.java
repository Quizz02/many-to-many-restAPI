package com.quizz.rest.Service;

import com.quizz.rest.Model.Tag;
import com.quizz.rest.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public void saveTag(Tag tag) {
        tagRepository.save(tag);
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    public void updateTag(Long id, Tag tag) {
        Tag updatedTag = tagRepository.findById(id).get();
        updatedTag.setName(tag.getName());
        tagRepository.save(updatedTag);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
