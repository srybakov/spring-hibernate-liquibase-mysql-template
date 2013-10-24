package com.nnprivate.project.common;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
public final class Utils {

    private static final String REDIRECT_TAG = "redirect:/";

    public static final ModelAndView redirectToView(String viewName){
        return new ModelAndView(REDIRECT_TAG + viewName);
    }

    public static void putParamToModel(ModelMap model, String paramName, Object paramValue) {
        model.put(paramName, paramValue);
    }
}
