package edu.mum.cs245.eregistrar.repository;
import edu.mum.cs245.eregistrar.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
