package ca.humber.group2.cpan228finalproject.repository;

import ca.humber.group2.cpan228finalproject.model.Event;
import ca.humber.group2.cpan228finalproject.model.EventType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByType(EventType type, Sort sort);
}