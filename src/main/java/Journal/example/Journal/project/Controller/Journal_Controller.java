package Journal.example.Journal.project.Controller;

import Journal.example.Journal.project.Entity.JournalEntry;
import Journal.example.Journal.project.Entity.User;
import Journal.example.Journal.project.Service.Journal_Service;
import Journal.example.Journal.project.Service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class Journal_Controller {

    @Autowired
    Journal_Service js ;

    @Autowired
    User_Service userService;

    @PostMapping("/save")
    public void Save(@RequestBody JournalEntry journalEntry)
    {
     js.saveentry(journalEntry);
    }
    @RequestMapping("/findAll")
    public List<JournalEntry> findall()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findbyusername(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK).getBody();
        }
        return (List<JournalEntry>) new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return js.findAll();
    }
    @RequestMapping("/id/{id}")
    public Optional<JournalEntry> find(@PathVariable String id)
    {
        return js.findentry(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id)
    {
        js.deleteentry(id);
    }
    @PutMapping("/update/{id}")
    public void updatebyId(@RequestBody JournalEntry journalEntry, @PathVariable String id)
    {
        if(js.findentry(id)!=null)
        {
            js.deleteentry(id);
            journalEntry.setId(id);
            js.saveentry(journalEntry);
        }



    }






}
