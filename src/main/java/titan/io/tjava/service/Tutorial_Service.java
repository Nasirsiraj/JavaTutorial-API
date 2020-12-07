package titan.io.tjava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titan.io.tjava.model.Tutorial;
import titan.io.tjava.repository.Tutorial_Repository;

import java.util.List;

@Slf4j
@Service
public class Tutorial_Service {
    @Autowired
    Tutorial_Repository tutorialRepository;

    // get all tutorial
    public List<Tutorial> getTutorialList(){
        log.info("getting all tutorial.");
        return tutorialRepository.findAll();
    }
    // get tutorial by id
    public Tutorial getTutorial(int id$){
        log.info("getting tutorial by id: " + id$ + ".");
        return tutorialRepository.findById(id$).orElse(null);
    }
    // post all tutorial
    public List<Tutorial> postTutorialList(List<Tutorial> tutorialList$){
        log.info("saving all tutorials.");
        return tutorialRepository.saveAll(tutorialList$);
    }
    // post one tutorial
    public Tutorial postTutorial(Tutorial tutorial$){
        log.info("saving one tutorial.");
        return tutorialRepository.save(tutorial$);
    }
    // delete tutorial by id
    public String deleteTutorial(int id$){
        Tutorial tutorial_ = tutorialRepository.findById(id$).orElse(null);
        if(tutorial_ != null){
            log.warn("deleting tutorial!! id: " + id$ + ".");
            tutorialRepository.deleteById(id$);
            return "tutorial deleted, id: " + id$;
        }else{
            log.warn("deleting tutorial failed, id: " + id$ + ".");
            return "tutorial not found! id: " + id$;
        }
    }
    // delete tutorial by obj
    public String deleteTutorial(Tutorial tutorial$){
        Tutorial tutorial_ = tutorialRepository.findById(tutorial$.getId()).orElse(null);
        if(tutorial_ != null){
            log.warn("deleting tutorial!! id: " + tutorial$.getId() + ".");
            tutorialRepository.delete(tutorial$);
            return "tutorial deleted, id: " + tutorial$.getId();
        }else{
            log.warn("deleting tutorial failed!! id: " + tutorial$.getId() + ".");
            return "tutorial not found! id: " + tutorial$.getId();
        }
    }
    // update tutorial
    public Tutorial updateTutorial(Tutorial tutorial$){
        Tutorial tutorial_ = tutorialRepository.findById(tutorial$.getId()).orElse(null);
        if(tutorial_ != null){
            tutorial_.setTitle(tutorial$.getTitle());
            tutorial_.setContent(tutorial$.getContent());
            tutorial_.setExample(tutorial$.getExample());
            tutorial_.setWriterId(tutorial$.getWriterId());

            log.info("updating tutorial, id: " + tutorial$.getId() + ".");
            return tutorialRepository.save(tutorial_);
        }else{
            return null;
        }
    }
}
