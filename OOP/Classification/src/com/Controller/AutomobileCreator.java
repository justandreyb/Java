package com.Controller;

import com.Model.Automobile;

public interface AutomobileCreator{

    Automobile getAutomobile(String automobileType) throws Exception;

}
