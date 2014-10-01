package com.monsanto.hive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: RDESAI2
 * Date: 10/17/13
 * Time: 1:25 PM
 */
@Controller
public class HiveQueryInputForm {

    public static final String HIVE_QUERY_INPUT_FORM = "hivequeryinputform";

    @RequestMapping("/enter-hive-query")
    public ModelAndView showHiveQueryEntryForm() throws Exception {
        System.out.println("controller '/enter-hive-query' invoked..");
        return new ModelAndView(HIVE_QUERY_INPUT_FORM);
    }
}
