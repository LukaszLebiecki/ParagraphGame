package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCard;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCardDao;

public class PlayerCardService {
    private final PlayerCardDao playerCardDao = new PlayerCardDao();

    public PlayerCardBasicInfo find(int idUser) {
        return PlayerMapper.map(playerCardDao.find(idUser));
    }

    private static class PlayerMapper {
        static PlayerCardBasicInfo map(PlayerCard p) {
            return new PlayerCardBasicInfo(
                    p.getNamePlayer(),
                    p.getOccupation(),
                    p.getAge(),
                    p.getSex(),
                    p.getResidence(),
                    p.getBirthplace());
        }
    }
}
