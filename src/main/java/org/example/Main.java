package org.example;

import org.example.adapter.*;
import org.example.builder.Computer;
import org.example.builder.ComputerBuilder;
import org.example.builder.ComputerDirector;
import org.example.builder.DesktopComputerBuilder;
import org.example.chain_of_responsibility.*;
import org.example.command.*;
import org.example.factory.Dish;
import org.example.factory.DishFactory;
import org.example.factory.PizzaFactory;
import org.example.factory.SushiFactory;
import org.example.flyweight.Character;
import org.example.flyweight.CharacterFactory;
import org.example.observer.Investor;
import org.example.observer.StockMarketImpl;
import org.example.observer.StockObserver;
import org.example.singleton.SimpleSingleton;
import org.example.singleton.ThreadSafeSingleton;
import org.example.state.State;
import org.example.state.TVContext;
import org.example.state.TVStartState;
import org.example.state.TVStopState;
import org.example.strategy.EasyLevel;
import org.example.strategy.Game;
import org.example.strategy.MediumLevel;
import org.example.strategy.HardLevel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Select a design pattern
                1. Singleton
                2. Builder
                3. Factory Method
                4. Adapter
                5. Flyweight
                6. Strategy
                7. Observer
                8. State
                9. Chain of Responsibility
                10. Command
                """);
        int num = sc.nextInt();
        switch (num) {
            case 1 -> {
                SimpleSingleton.getInstance("simple singleton");
                ThreadSafeSingleton.getInstance("thread safe singleton");
            }
            case 2 -> {
                ComputerBuilder desktopBuilder = new DesktopComputerBuilder();
                ComputerDirector director = new ComputerDirector(desktopBuilder);
                Computer desktop = director.constructComputer();
                System.out.println(desktop);
            }
            case 3 -> {
                DishFactory pizzaFactory = new PizzaFactory();
                Dish pizza = pizzaFactory.createDish();
                pizza.prepare();
                pizza.serve();

                DishFactory sushiFactory = new SushiFactory();
                Dish sushi = sushiFactory.createDish();
                sushi.prepare();
                sushi.serve();
            }
            case 4 -> {
                PaymentGateway paypalGateway = new PayPalAdapter(new PayPal());
                PaymentGateway stripeGateway = new StripeAdapter(new Stripe());

                double amount = 100.0;

                paypalGateway.processPayment(amount);
                stripeGateway.processPayment(amount);
            }
            case 5 -> {
                CharacterFactory characterFactory = new CharacterFactory();
                org.example.flyweight.Character character1 = characterFactory.getCharacter('A');
                character1.display("Arial");
                org.example.flyweight.Character character2 = characterFactory.getCharacter('B');
                character2.display("Times New Roman");
                Character character3 = characterFactory.getCharacter('A');
                character3.display("Calibri");
            }
            case 6 -> {
                Game game = new Game(new EasyLevel());

                game.startGame();  // Start game with easy difficulty

                game.setDifficultyLevel(new MediumLevel());
                game.startGame();  // Switch to medium difficulty

                game.setDifficultyLevel(new HardLevel());
                game.startGame();  // Play on hard difficulty
            }
            case 7 -> {
                StockMarketImpl stockMarket = new StockMarketImpl();

                StockObserver investor1 = new Investor("Alice");
                StockObserver investor2 = new Investor("Bob");

                stockMarket.registerObserver(investor1);
                stockMarket.registerObserver(investor2);

                stockMarket.setStockPrice("INFY", 1250.0); // Both investors receive updates
                stockMarket.setStockPrice("TCS", 2500.0); // Both investors receive updates

                stockMarket.removeObserver(investor1);

                stockMarket.setStockPrice("WIPRO", 700.0); // Only investor2 receives the update
            }
            case 8 -> {
                TVContext context = new TVContext();
                State tvStartState = new TVStartState();
                State tvStopState = new TVStopState();

                context.setState(tvStartState);
                context.doAction();

                context.setState(tvStopState);
                context.doAction();
            }
            case 9 -> {
                SupportHandler level1Handler = new Level1SupportHandler();
                SupportHandler level2Handler = new Level2SupportHandler();
                SupportHandler level3Handler = new Level3SupportHandler();

                level1Handler.setNextHandler(level2Handler);
                level2Handler.setNextHandler(level3Handler);

                Request request1 = new Request(Priority.BASIC);
                Request request2 = new Request(Priority.INTERMEDIATE);
                Request request3 = new Request(Priority.CRITICAL);

                level1Handler.handleRequest(request1);
                level1Handler.handleRequest(request2);
                level1Handler.handleRequest(request3);
            }
            case 10 -> {
                // Create devices
                TV tv = new TV();
                Stereo stereo = new Stereo();

                // Create command objects
                Command turnOnTVCommand = new TurnOnCommand(tv);
                Command turnOffTVCommand = new TurnOffCommand(tv);
                Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo);
                Command changeChannelTVCommand = new ChannelChangeCommand(tv);

                // Create remote control
                RemoteControl remote = new RemoteControl();

                // Set and execute commands
                remote.setCommand(turnOnTVCommand);
                remote.pressButton(); // Outputs: TV is now on

                remote.setCommand(adjustVolumeStereoCommand);
                remote.pressButton(); // Outputs: Volume adjusted

                remote.setCommand(changeChannelTVCommand);
                remote.pressButton(); // Outputs: Channel changed

                remote.setCommand(turnOffTVCommand);
                remote.pressButton(); // Outputs: TV is now off
            }
            default -> throw new IllegalStateException("Unexpected value: " + num);
        }
    }
}
