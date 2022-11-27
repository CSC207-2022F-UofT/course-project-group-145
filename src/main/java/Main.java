import chat.*;
import chat_use_case.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.MessageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        MessageRepository messages = new MessageRepository("message.json");
//        MessageRepoRequestModel message = new MessageRepoRequestModel(0, "hello", 1, 2, new Date(), new Date(), false, false, false , -1);
//        messages.save(message);
//        messages.delete(2);

        ChatRepository chat = new ChatRepository("chat.json");
        List<Integer> ids = new ArrayList<>();
//        ids.add(0);
//
        chat.save(new ChatRepoRequestModel(0, ids, false));
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
        Map<Integer, ChatRepoRequestModel> chats = chatRepoGateway.getAllChats();
        MessageFactory factory = new MessageFactory();
        DeleteMessageInputBoundary delete = new DeleteMessage(presenter, messageRepoGateway);
        SendMessageInputBoundary send = new SendMessage(factory, presenter, messageRepoGateway, chatRepoGateway);
        EditMessageInputBoundary edit = new EditMessage(presenter, messageRepoGateway);
        ChatController controller = new ChatController(delete, edit, send);
        view.setController(controller);
//        List<Integer> ids = new ArrayList<>();
//        ids.add(0);
//        ids.add(1);
//        ids.add(2);
////        ids.add(3);
////        ids.add(4);
        List<MessageRepoRequestModel> messages = messageRepoGateway.getMessages(chats.get(1).getMessageIds());
        view.setChatId(1);
        view.setUserId(1);
        view.setOtherUser(2);
        view.addMessages(messages);


        screens.add(view, "Chat");
        cardLayout.show(screens, "Chat");
        application.pack();
        application.setVisible(true);





    }

}
