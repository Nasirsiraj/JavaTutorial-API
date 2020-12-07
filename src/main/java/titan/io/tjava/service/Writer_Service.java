package titan.io.tjava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titan.io.tjava.model.Writer;
import titan.io.tjava.repository.Writer_Repository;

import java.util.List;

@Slf4j
@Service
public class Writer_Service {
    @Autowired
    Writer_Repository writerRepository;

    // get all writer
    public List<Writer> getWriterList(){
        log.info("getting all writer.");
        return writerRepository.findAll();
    }
    // get writer by id
    public Writer getWriter(int id$){
        log.info("getting writer by id: " + id$ + ".");
        return writerRepository.findById(id$).orElse(null);
    }
    // post all writer
    public List<Writer> postWriterList(List<Writer> writerList$){
        log.info("saving all writer.");
        return writerRepository.saveAll(writerList$);
    }
    // post one writer
    public Writer postWriter(Writer writer$){
        log.info("saving one writer.");
        return writerRepository.save(writer$);
    }
    // delete writer by id
    public String deleteWriter(int id$){
        Writer writer_ = writerRepository.findById(id$).orElse(null);
        if(writer_ != null){
            log.warn("writer deleting, id: " + id$ + "!!");
            writerRepository.deleteById(id$);
            return "writer deleted, id: " + id$;
        }else{
            log.warn("writer deleting failed, id: " + id$ + "!");
            return "writer not found! id: " + id$;
        }
    }
    // delete writer by obj
    public String deleteWriter(Writer writer$){
        Writer writer_ = writerRepository.findById(writer$.getId()).orElse(null);
        if(writer_ != null){
            log.warn("writer deleting, id: " + writer$.getId() + "!");
            writerRepository.delete(writer$);
            return "writer deleted, id: " + writer$.getId();
        }else{
            log.warn("writer deleting failed, id: " + writer$.getId() + "!");
            return "writer not found! id: " + writer$.getId();
        }
    }
    // update writer
    public Writer updateWriter(Writer writer$){
        Writer writer_ = writerRepository.findById(writer$.getId()).orElse(null);
        if(writer_ != null){
            writer_.setName(writer$.getName());
            writer_.setEmail(writer$.getEmail());
            writer_.setPassword(writer$.getPassword());

            log.info("writer updating, id: " + writer$.getId() + ".");
            return writerRepository.save(writer_);
        }else{
            return null;
        }
    }
}
