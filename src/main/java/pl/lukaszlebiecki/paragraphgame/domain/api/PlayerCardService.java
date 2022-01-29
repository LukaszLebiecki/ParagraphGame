package pl.lukaszlebiecki.paragraphgame.domain.api;

import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCard;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerCardDao;
import pl.lukaszlebiecki.paragraphgame.domain.playerCard.PlayerSex;

public class PlayerCardService {
    private final PlayerCardDao playerCardDao = new PlayerCardDao();

    public void updatePlayerCard(int userId, String name, String occupation,
                                 Integer age, PlayerSex sex, String residence, String birthplace) {
        playerCardDao.update(userId, name, occupation, age, sex, residence, birthplace);
    }

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
