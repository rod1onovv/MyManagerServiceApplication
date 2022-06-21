package ru.alsu.taskmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alsu.taskmanager.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByName(String name);

    Project findProjectById(Long id);


}
