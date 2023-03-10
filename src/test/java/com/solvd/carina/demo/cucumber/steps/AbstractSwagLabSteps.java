package com.solvd.carina.demo.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import com.solvd.carina.demo.services.DBOrderService;
import com.solvd.carina.demo.services.DBUserService;
import com.solvd.carina.demo.utils.RandomUtil;

public abstract class AbstractSwagLabSteps extends CucumberRunner {

    public DBUserService dbUserService = new DBUserService();

    public DBOrderService dbOrderService = new DBOrderService();

    public RandomUtil randomUtil = new RandomUtil();
}
