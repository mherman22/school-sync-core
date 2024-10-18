package com.mgms.service.impl;

import com.mgms.dao.TimetableDao;
import com.mgms.dto.TimetableDTO;
import com.mgms.model.Timetable;
import com.mgms.service.TimetableService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

  @Autowired private TimetableDao timetableDao;

  @Override
  public List<TimetableDTO> getAllTimetables() {
    return timetableDao.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public TimetableDTO getTimetableById(Long id) {
    Timetable timetable = timetableDao.findById(id);
    return timetable != null ? convertToDTO(timetable) : null;
  }

  @Override
  public List<TimetableDTO> getTimetablesByClass(Long classId) {
    return timetableDao.findByClassId(classId).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public List<TimetableDTO> getTimetablesByTeacher(Long teacherId) {
    return timetableDao.findByTeacherId(teacherId).stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public TimetableDTO createTimetable(TimetableDTO timetableDTO) {
    Timetable timetable = convertToEntity(timetableDTO);
    return convertToDTO(timetableDao.save(timetable));
  }

  @Override
  public TimetableDTO updateTimetable(Long id, TimetableDTO timetableDTO) {
    Timetable timetable = timetableDao.findById(id);
    if (timetable != null) {
      timetable.setClassObj(timetableDTO.getClassObj());
      timetable.setTeacher(timetableDTO.getTeacher());
      timetable.setSubject(timetableDTO.getSubject());
      timetable.setDayOfWeek(timetableDTO.getDayOfWeek());
      timetable.setStartTime(timetableDTO.getStartTime());
      timetable.setEndTime(timetableDTO.getEndTime());
      return convertToDTO(timetableDao.save(timetable));
    }
    return null;
  }

  @Override
  public void deleteTimetable(Long id) {
    timetableDao.deleteById(id);
  }

  private TimetableDTO convertToDTO(Timetable timetable) {
    TimetableDTO dto = new TimetableDTO();
    dto.setId(timetable.getId());
    dto.setClassObj(timetable.getClassObj());
    dto.setTeacher(timetable.getTeacher());
    dto.setSubject(timetable.getSubject());
    dto.setDayOfWeek(timetable.getDayOfWeek());
    dto.setStartTime(timetable.getStartTime());
    dto.setEndTime(timetable.getEndTime());
    return dto;
  }

  private Timetable convertToEntity(TimetableDTO dto) {
    Timetable timetable = new Timetable();
    timetable.setId(dto.getId());
    timetable.setClassObj(dto.getClassObj());
    timetable.setTeacher(dto.getTeacher());
    timetable.setSubject(dto.getSubject());
    timetable.setDayOfWeek(dto.getDayOfWeek());
    timetable.setStartTime(dto.getStartTime());
    timetable.setEndTime(dto.getEndTime());
    return timetable;
  }
}
