package edu.mum.cs245.eregistrar.service.imp;

import edu.mum.cs245.eregistrar.model.Transcript;
import edu.mum.cs245.eregistrar.repository.TranscriptRepository;
import edu.mum.cs245.eregistrar.service.TranscriptService;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    TranscriptRepository transcriptRepository;

    TranscriptServiceImpl(TranscriptRepository transcriptRepository){
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public Transcript addTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
}
