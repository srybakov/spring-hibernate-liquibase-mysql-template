package com.nnprivate.project.controllers;

import com.nnprivate.project.common.Constants;
import com.nnprivate.project.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.nnprivate.project.common.Utils.redirectToView;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SecurityService securityService;


    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
        if (securityService.isAuthorized()){
            return redirectToView(Constants.USER_CABINET);
        } else {
            return new ModelAndView(Constants.LOGIN_PAGE);
        }
	}

}