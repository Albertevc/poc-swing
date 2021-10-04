package br.com.aevc.pocswing.service;

import br.com.aevc.pocswing.model.LoginDTO;
import br.com.aevc.pocswing.model.LoginResponseVO;
import br.com.aevc.pocswing.model.NameAndPasswordVO;
import br.com.aevc.pocswing.model.dao.UserDAO;
import br.com.aevc.pocswing.service.exception.SystemException;

import java.sql.SQLException;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class LoginService {

    private final UserDAO userDAO = new UserDAO();

    public LoginResponseVO login(LoginDTO loginDTO) throws SystemException {
        try {
			NameAndPasswordVO nameAndPasswordVO = ofNullable(this.userDAO.selectNameAndPasswordBy(loginDTO.getRegistration()))
                    .orElse(new NameAndPasswordVO());
			return new LoginResponseVO(
                    nameAndPasswordVO.getName(),
					loginDTO.getRegistration(),
                    new String(loginDTO.getPassword()).equals(nameAndPasswordVO.getPassword())
			);
		} catch (SQLException e) {
            System.out.println(format("%s %s", e.getMessage(), e));
            throw new SystemException(e.getMessage(), e);
        }
    }

}
