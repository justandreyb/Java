package com.Client.View;

import java.awt.*;
import java.awt.event.*;

public class InterfaceVK {

    protected final String client_id = "5476183";

    private static final String API_VERSION = "5.21";

    private static final String AUTH_URL = "https://oauth.vk.com/authorize"
            + "?client_id={APP_ID}"
            + "&scope={PERMISSIONS}"
            + "&redirect_uri={REDIRECT_URI}"
            + "&display={DISPLAY}"
            + "&v={API_VERSION}"
            + "&response_type=token";

    private static final String API_REQUEST = "https://api.vk.com/method/{METHOD_NAME}"
            + "?{PARAMETERS}"
            + "&access_token={ACCESS_TOKEN}"
            + "&v=" + API_VERSION;

    public static void main(String[] args) throws AWTException {
        //Создадим раскрывающееся меню
        PopupMenu popup = new PopupMenu();
//Создадим элемент меню
        MenuItem exitItem = new MenuItem("Выход");
//Добавим для него обработчик
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//Добавим пункт в меню
        popup.add(exitItem);
        SystemTray systemTray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\img\\icoPlusAcc.jpg");
        TrayIcon trayIcon = new TrayIcon(image,"VK - justandreyb",popup);
        trayIcon.setImageAutoSize(true);
//добавим иконку в трей
        systemTray.add(trayIcon);
//тестовое сообщение
        trayIcon.displayMessage("New notification from VK", "Hello here", TrayIcon.MessageType.INFO);
    }



}
