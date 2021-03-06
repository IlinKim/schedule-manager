package com.ilsee.schedulemanager.domain.timeline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface TimeLineRepository extends JpaRepository<TimeLine, Long> {
    List<TimeLine> findAllByStartGreaterThanEqual(LocalTime start);
    List<TimeLine> findAllByStartGreaterThanEqualAndEndLessThanEqual(LocalTime start, LocalTime end);
}
