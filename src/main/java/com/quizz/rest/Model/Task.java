package com.quizz.rest.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tasks", schema = "todocrud")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String status;
    @ManyToMany
    @JoinTable(name = "task_tags", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    public String toString() {
        return String.format("Task [id=%s, title=%s, description=%s, status=%s]", id, title, description, status);
    }
}
