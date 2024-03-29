package com.quizz.rest.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tags", schema = "todocrud")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;
    @Column
    private String name;
    //TODO: tag can only be deleted when its not assigned to a task, fix that
    @JsonIgnore // avoid infinite loop of task inside tag and tag inside task
    @ManyToMany(mappedBy = "tags")
    private Set<Task> tasks = new HashSet<>();
}
