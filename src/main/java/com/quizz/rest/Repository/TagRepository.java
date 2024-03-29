package com.quizz.rest.Repository;

import com.quizz.rest.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
