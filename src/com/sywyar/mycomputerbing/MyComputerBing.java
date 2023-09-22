package com.sywyar.mycomputerbing;

import com.sywyar.my.api.CommandTypeException;
import com.sywyar.my.api.MyComputerPlugin;
import com.sywyar.my.api.MyComputerPluginID;
import com.sywyar.my.api.RegisterCommand;
import com.sywyar.mycomputerbing.command.Bing;

import static com.sywyar.mycomputerbing.MyComputerBing.MY_COMPUTER_PLUGIN_ID;

@MyComputerPluginID(MY_COMPUTER_PLUGIN_ID)
public class MyComputerBing implements MyComputerPlugin{
    public static final String MY_COMPUTER_PLUGIN_ID = "MyComputerBing";

    @Override
    public void loadPlugin() {
        try {
            RegisterCommand.addCommand(new Bing());
        } catch (CommandTypeException e) {
            throw new RuntimeException(e);
        }
    }
}
