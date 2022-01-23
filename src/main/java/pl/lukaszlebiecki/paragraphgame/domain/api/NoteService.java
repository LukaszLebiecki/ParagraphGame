package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.notes.Note;
import pl.lukaszlebiecki.paragraphgame.domain.notes.NoteDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoteService {

    private final NoteDao noteDao = new NoteDao();

    public void deleteNote(int userId, String textNote) {
        noteDao.delete(userId, textNote);
    }

    public void saveNewNote(int userId, String textNote) {
        noteDao.save(userId, textNote);
    }

    public List<NoteBasicInfo> findAll(int idUser) {
        List<NoteBasicInfo> noteBasicInfos = new ArrayList<>();
        return noteDao.findAll(idUser)
                .stream().map(NoteAllMapper::map)
                .collect(Collectors.toList());
    }

    private static class NoteAllMapper {
        static NoteBasicInfo map(Note n) {
            return new NoteBasicInfo(
                    n.getNote()
            );
        }
    }
}
