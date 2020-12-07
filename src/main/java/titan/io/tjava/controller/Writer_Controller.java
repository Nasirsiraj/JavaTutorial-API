package titan.io.tjava.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import titan.io.tjava.model.Writer;
import titan.io.tjava.service.Writer_Service;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Writer_Controller {
    @Autowired
    Writer_Service writerService;

    // get all writer
    @GetMapping("/writers")
    public List<Writer> getWriterList(){
        return writerService.getWriterList();
    }
    // get writer by id
    @GetMapping("/writer/{id$}")
    public Writer getWriter(@PathVariable int id$){
        return writerService.getWriter(id$);
    }
    // post all writer
    @PostMapping("/writers")
    public List<Writer> postWriterList(@RequestBody List<Writer> writerList$){
        return writerService.postWriterList(writerList$);
    }
    // post one writer
    @PostMapping("/writer")
    public Writer postWriter(@RequestBody Writer writer$){
        return writerService.postWriter(writer$);
    }
    // delete writer by id
    @DeleteMapping("/writer/{id$}")
    public String deleteWriter(@PathVariable int id$){
        return writerService.deleteWriter(id$);
    }
    // delete writer by obj
    @DeleteMapping("/writer")
    public String deleteWriter(@RequestBody Writer writer$){
        return writerService.deleteWriter(writer$);
    }
    // update writer obj
    @PutMapping("/writer")
    public Writer updateWriter(@RequestBody Writer writer$){
        return writerService.updateWriter(writer$);
    }
}
