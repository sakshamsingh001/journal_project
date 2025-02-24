package Journal.example.Journal.project.Service;

import Journal.example.Journal.project.Entity.JournalEntry;
import Journal.example.Journal.project.Repository.journal_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Journal_Service {

@Autowired
    private journal_repo jr;

//SAVE ENTRY
public void saveentry(JournalEntry entry)
{
    jr.save(entry);
}
//DELETE ENTRY
    public void deleteentry(String id)
    {
        jr.deleteById(id);
    }
//  FIND ENTRY BY ID
    public Optional<JournalEntry> findentry(String id)
    {
        return jr.findById(id);
    }

//  FIND ENTRY BY CONTENT
//  FIND ENTRY BY TITLE
//  FIND ALL THE ENTRIES
    public List<JournalEntry> findAll()
    {
        return jr.findAll();
    }





}
