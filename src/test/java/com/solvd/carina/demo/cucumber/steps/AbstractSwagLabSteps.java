package com.solvd.carina.demo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.solvd.carina.demo.services.DBOrderService;
import com.solvd.carina.demo.services.DBUserService;
import com.solvd.carina.demo.utils.RandomUtil;

public abstract class AbstractSwagLabSteps extends CucumberRunner {

    protected DBUserService dbUserService = new DBUserService();

    protected DBOrderService dbOrderService = new DBOrderService();

    protected RandomUtil randomUtil = new RandomUtil();
}
