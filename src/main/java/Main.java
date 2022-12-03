
import controller_presenter_gateway.chat_controller_presenter_gateway.*;
import entities.MessageFactory;
import ui.ChatView;
import use_cases.chat_use_cases.*;

import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // this is to set up something to demo, comment out later
        ChatRepository chat = new ChatRepository("chat.json");
        List<Integer> ids = new ArrayList<>();
        ids.add(0);
        ids.add(1);

        chat.save(new ChatRepoRequestModel(0, ids, false));

        MessageRepoGateway messageGateway = new MessageRepository("message.json");
        MessageRepoRequestModel message = new MessageRepoRequestModel(0, "hello", 0, 1, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message);
        MessageRepoRequestModel message1 = new MessageRepoRequestModel(1, "hello there", 1, 0, new Date(), new Date(), false, false, false , -1);
        messageGateway.save(message1);


        JFrame application = new JFrame("Chat");
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        ChatView view = new ChatView();
        MessageRepoGateway messageRepoGateway = new MessageRepository("message.json");
        ChatRepoGateway chatRepoGateway = new ChatRepository("chat.json");
        ChatOutputBoundary presenter = new ChatPresenter(view, chatRepoGateway, messageRepoGateway);
        MessageFactory factory = new MessageFactory();
        DeleteMessageInputBoundary delete = new DeleteMessage(presenter, messageRepoGateway);
        SendMessageInputBoundary send = new SendMessage(factory, presenter, messageRepoGateway, chatRepoGateway);
        EditMessageInputBoundary edit = new EditMessage(presenter, messageRepoGateway);
        ChatController controller = new ChatController(delete, edit, send);
        view.setController(controller);

        JPanel panel = new test(presenter);

        presenter.openChat(0, 0, 1);


        screens.add(view, "Chat");
        screens.add(panel, "hello");
        cardLayout.show(screens, "Chat");
        application.pack();
        application.setVisible(true);



    }

}
