package pl.lukaszlebiecki.paragraphgame.domain.api;

import org.apache.commons.codec.digest.DigestUtils;
import pl.lukaszlebiecki.paragraphgame.domain.user.User;
import pl.lukaszlebiecki.paragraphgame.domain.user.UserDao;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class UserService {
    private UserDao userDao = new UserDao();


    public UserBasicInfo findUser(String username) {
        return userDao.findUserByName(username);
    }

    public void updateParagraph(int userId, int newParagraphMainId) {
        userDao.update(userId, newParagraphMainId);
    }

    public void register(UserRegistration userRegistration) {
        User userToSave = UserMapper.map(userRegistration);
        try {
            hashPasswordWithSha256(userToSave);
            userDao.save(userToSave);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    private void hashPasswordWithSha256(User user) throws NoSuchAlgorithmException {
        String sha256Password = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(sha256Password);
    }


    private static class UserMapper {
        static User map(UserRegistration userRegistration) {
            return new User(
                    userRegistration.getUserName(),
                    userRegistration.getPassword(),
                    userRegistration.getEmail(),
                    LocalDateTime.now()
            );
        }
    }

}
