package titan.io.tjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import titan.io.tjava.model.Tutorial;
import titan.io.tjava.service.Tutorial_Service;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Tutorial_Controller {
    @Autowired
    Tutorial_Service tutorialService;

    // get all tutorial
    @GetMapping("/tutorials")
    public List<Tutorial> getTutorialList(){
        return tutorialService.getTutorialList();
    }
    // get tutorial by id
    @GetMapping("/tutorial/{id$}")
    public Tutorial getTutorial(@PathVariable int id$){
        return tutorialService.getTutorial(id$);
    }
    // post all tutorial
    @PostMapping("/tutorials")
    public List<Tutorial> postTutorialList(@RequestBody List<Tutorial> tutorialList$){
        return tutorialService.postTutorialList(tutorialList$);
    }
    // post one tutorial
    @PostMapping("/tutorial")
    public Tutorial postTutorial(@RequestBody Tutorial tutorial$){
        return tutorialService.postTutorial(tutorial$);
    }
    // delete tutorial by id
    @DeleteMapping("/tutorial/{id$}")
    public String deleteTutorial(@PathVariable int id$){
        return tutorialService.deleteTutorial(id$);
    }
    // delete tutorial obj
    @DeleteMapping("/tutorial")
    public String deleteTutorial(@RequestBody Tutorial tutorial$){
        return tutorialService.deleteTutorial(tutorial$);
    }
    // update tutorial obj
    @PutMapping("/tutorial")
    public Tutorial updateTutorial(@RequestBody Tutorial tutorial$){
        return tutorialService.updateTutorial(tutorial$);
    }
}
