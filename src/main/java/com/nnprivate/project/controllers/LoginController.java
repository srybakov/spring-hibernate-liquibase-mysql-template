package com.nnprivate.project.controllers;

import com.nnprivate.project.common.Constants;
import com.nnprivate.project.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.nnprivate.project.common.Utils.putParamToModel;
import static com.nnprivate.project.common.Utils.redirectToView;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Controller
@RequestMapping("/")
public class LoginController {

    private final static String USER_OR_PASSWORD_INCORRECT = "Incorrect email or password. Please try again";
    private final static String INCORRECT_LOGIN = "incorrectLogin";

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
        if (securityService.isAuthorized()){
            return redirectToView(Constants.USER_CABINET);
        } else {
            return new ModelAndView(Constants.LOGIN);
        }
	}

    @RequestMapping(value = Constants.LOGIN_FAILED_ACTION, method = RequestMethod.GET)
    public ModelAndView loginFailed(ModelMap model) {
        putParamToModel(model, INCORRECT_LOGIN, USER_OR_PASSWORD_INCORRECT);
        return new ModelAndView(Constants.LOGIN);
    }
}