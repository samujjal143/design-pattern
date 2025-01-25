package org.example.command;

public class ChannelChangeCommand implements Command {
    private TV tv;

    public ChannelChangeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}
