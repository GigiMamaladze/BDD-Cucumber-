package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.services.DBOrderService;
import com.solvd.carina.demo.services.DBUserService;
import com.solvd.carina.demo.utils.RandomUtil;

public abstract class AbstractSwagLabTest extends AbstractTest {

    protected DBUserService dbUserService = new DBUserService();

    protected DBOrderService dbOrderService = new DBOrderService();

    protected RandomUtil randomUtil = new RandomUtil();
}
