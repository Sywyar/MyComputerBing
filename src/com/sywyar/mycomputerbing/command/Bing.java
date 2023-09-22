package com.sywyar.mycomputerbing.command;

import com.sywyar.my.api.Command;
import com.sywyar.my.api.CommandDescription;
import com.sywyar.superjsonobject.SuperJsonObject;

import java.io.IOException;

import static com.sywyar.mycomputerbing.MyComputerBing.MY_COMPUTER_PLUGIN_ID;

public class Bing implements Command {
    @Override
    public String getCommandType() {
        return "1";
    }

    @Override
    public CommandDescription getCommandDescription() {
        CommandDescription commandDescription = new CommandDescription();
        commandDescription.setSimplifiedChineseDescription("使用Bing搜索对应内容");
        commandDescription.setTraditionalChineseDescription("使用Bing搜索對應內容");
        commandDescription.setEnglishDescription("Use Bing to search for corresponding content");
        commandDescription.setJapaneseDescription("Bing を使用して対応するコンテンツを検索する");
        return commandDescription;
    }

    @Override
    public String getMyComputerPluginID() {
        return MY_COMPUTER_PLUGIN_ID;
    }

    @Override
    public void run(SuperJsonObject info) {
        try {
            new ProcessBuilder("cmd", "/c", "start https://cn.bing.com/search?q="+info.getAsString("text")).inheritIO().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
