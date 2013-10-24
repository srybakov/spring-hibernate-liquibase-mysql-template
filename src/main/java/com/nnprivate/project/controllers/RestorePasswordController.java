package com.nnprivate.project.controllers;

import com.nnprivate.project.common.Constants;
import com.nnprivate.project.service.SecurityService;
import com.nnprivate.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.nnprivate.project.common.Utils.putParamToModel;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Controller
@RequestMapping(value = Constants.RESTORE_PASSWORD)
public class RestorePasswordController {

    private static final String EMAIL_IS_SENT = "sent";
    private static final String EMAIL = "email";

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView restorePassword(){
        return new ModelAndView(Constants.RESTORE_PASSWORD);
    }

    @RequestMapping(value = Constants.SEND_RESTORE_EMAIL_ACTION, method = RequestMethod.POST)
    public ModelAndView sendRestoreEmail(ModelMap model,
                                         @RequestParam(value = EMAIL, required = true) String email){

        putParamToModel(model, EMAIL_IS_SENT, true);
        putParamToModel(model, EMAIL, email);
        return new ModelAndView(Constants.RESTORE_PASSWORD, model);
    }
}
