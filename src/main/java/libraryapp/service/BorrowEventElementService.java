package libraryapp.service;

import libraryapp.dto.BorrowEventElementDtoIn;
import libraryapp.entity.BorrowEventElement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public interface BorrowEventElementService {

    Optional<BorrowEventElement> add(BorrowEventElementDtoIn newElement);
    void delete(UUID eventElementId);
    Optional<BorrowEventElement> update(UUID eventElementId, BorrowEventElementDtoIn updatedElement);
    Optional<BorrowEventElement> updateEndDate(UUID eventElementId, LocalDate newEndDate);
    Optional<BorrowEventElement> findByid(UUID eventId);
}
